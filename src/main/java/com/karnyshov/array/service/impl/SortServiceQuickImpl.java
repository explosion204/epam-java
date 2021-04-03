package com.karnyshov.array.service.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceQuickImpl implements SortService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array is null");
        }

        int arrayLength = array.getLength();

        if (arrayLength > 1) {
            internalQuickSort(array, 0, array.getLength() - 1);
            logger.debug("Sorted array (with quick sort): " + array.toString());
        }
    }

    private void internalQuickSort(CustomArray array, int low, int high)
            throws CustomArrayException {
        if (low < high) {
            int pivot = array.get(high);
            int i = low - 1;

            for (int j = low; j <= high - 1; j++) {
                if (array.get(j) < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }

            int partitionIndex = i + 1;
            swap(array, partitionIndex, high);
            internalQuickSort(array, low, partitionIndex - 1);
            internalQuickSort(array, partitionIndex + 1, high);
        }
    }

    private void swap(CustomArray array, int i, int j) throws CustomArrayException {
        int iElement = array.get(i);
        int jElement = array.get(j);
        array.set(i, jElement);
        array.set(j, iElement);
    }
}
