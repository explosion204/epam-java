package com.karnyshov.array.action.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.action.ArrayAggregationService;
import com.karnyshov.array.exception.CustomArrayException;

public class ArrayAggregationServiceImpl implements ArrayAggregationService {
    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int min = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }

        return min;
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int max = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }

        return max;
    }

    @Override
    public double findAvg(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return (double) sum / array.getLength();
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return sum;
    }

    @Override
    public int findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number >= 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number < 0) {
                count++;
            }
        }

        return count;
    }
}
