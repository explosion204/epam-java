package com.karnyshov.array.service.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceMergeImpl implements SortService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array is null");
        }

        internalMergeSort(array, array.getLength());
        logger.debug("Sorted array (with merge sort): " + array.toString());
    }

    private void internalMergeSort(CustomArray array, int length) throws CustomArrayException {
        if (length < 2) {
            return;
        }

        int middle = length / 2;
        CustomArray leftArr = new CustomArray(middle);
        CustomArray rightArr = new CustomArray(length - middle);

        for (int i = 0; i < middle; i++) {
            int number = array.get(i);
            leftArr.set(i, number);
        }

        for (int i = middle; i < length; i++) {
            int number = array.get(i);
            rightArr.set(i - middle, number);
        }

        internalMergeSort(leftArr, middle);
        internalMergeSort(rightArr, length - middle);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < middle && j < length - middle) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                int number = leftArr.get(i);
                array.set(k, number);
                k++;
                i++;
            } else {
                int number = rightArr.get(j);
                array.set(k, number);
                k++;
                j++;
            }
        }

        while (i < middle) {
            int number = leftArr.get(i);
            array.set(k, number);
            k++;
            i++;
        }

        while (j < length - middle) {
            int number = rightArr.get(j);
            array.set(k, number);
            k++;
            j++;
        }
    }
}
