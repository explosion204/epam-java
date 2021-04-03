package com.karnyshov.array.service.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceInsertionImpl implements SortService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array is null");
        }

        int arrayLength = array.getLength();

        if (arrayLength < 2) {
            return;
        }

        for (int i = 1; i < array.getLength(); i++) {
            int key = array.get(i);
            int j = i - 1;

            while (j >= 0 && array.get(j) > key) {
                int element = array.get(j);
                array.set(j + 1, element);
                j--;
            }

            array.set(j + 1, key);
        }

        logger.debug("Sorted array (with insertion sort): " + array.toString());
    }
}
