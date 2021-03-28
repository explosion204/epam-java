package com.karnyshov.array.action.impl;

import com.karnyshov.array.action.ArrayManipulationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayManipulationServiceImpl implements ArrayManipulationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void replace(CustomArray array, Predicate<Integer> predicate,
                        UnaryOperator<Integer> transform) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than one or equals to null (replace)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);
            boolean isMatch = predicate.test(number);

            if (isMatch) {
                int oldNumber = array.get(i);
                int newNumber = transform.apply(oldNumber);
                array.set(i, newNumber);
                logger.debug("Replaced value " + oldNumber + " with " + newNumber);
            }
        }
    }

    @Override
    public void mergeSort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (mergeSort)");
            throw new CustomArrayException("Array is null");
        }

        internalMergeSort(array, array.getLength());
        logger.debug("Sorted array (with merge sort): " + array.toString());
    }

    @Override
    public void quickSort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (quickSort)");
            throw new CustomArrayException("Array is null");
        }

        int arrayLength = array.getLength();

        if (arrayLength > 1) {
            internalQuickSort(array, 0, array.getLength() - 1);
            logger.debug("Sorted array (with quick sort): " + array.toString());
        }
    }

    @Override
    public void insertionSort(CustomArray array) throws CustomArrayException {
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

    private void internalMergeSort(CustomArray array, int length) throws CustomArrayException {
        if (length < 2) {
            return;
        }

        int middle = length / 2;
        CustomArray leftArr = CustomArray.createEmptyArray(middle);
        CustomArray rightArr = CustomArray.createEmptyArray(length - middle);

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
