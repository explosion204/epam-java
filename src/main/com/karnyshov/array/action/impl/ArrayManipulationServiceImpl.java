package com.karnyshov.array.action.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.action.ArrayManipulationService;
import com.karnyshov.array.entity.CustomArrayCreator;
import com.karnyshov.array.exception.CustomArrayException;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayManipulationServiceImpl implements ArrayManipulationService {
    @Override
    public void replace(CustomArray array, Predicate<Integer> predicate,
                        UnaryOperator<Integer> transform) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);
            boolean isMatch = predicate.test(number);

            if (isMatch) {
                int oldNumber = array.get(i);
                int newNumber = transform.apply(oldNumber);
                array.set(i, newNumber);
            }
        }
    }

    @Override
    public void mergeSort(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        CustomArrayCreator arrayCreator = new CustomArrayCreator();
        int arrayLength = array.getLength();
        internalMergeSort(arrayCreator, array, arrayLength);
    }

    private void internalMergeSort(CustomArrayCreator creator, CustomArray array, int length)
            throws CustomArrayException {
        if (length < 2) {
            return;
        }

        int middle = length / 2;
        CustomArray leftArr = creator.createEmptyArray(middle);
        CustomArray rightArr = creator.createEmptyArray(length - middle);

        for (int i = 0; i < middle; i++) {
            int number = array.get(i);
            leftArr.set(i, number);
        }

        for (int i = middle; i < length; i++) {
            int number = array.get(i);
            rightArr.set(i - middle, number);
        }

        internalMergeSort(creator, leftArr, middle);
        internalMergeSort(creator, rightArr, length - middle);

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
