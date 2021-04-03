package com.karnyshov.array.service.impl;

import com.karnyshov.array.service.AggregationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

import java.util.stream.IntStream;

public class AggregationServiceStreamImpl implements AggregationService {
    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array)
                .min()
                .orElseThrow(() -> new CustomArrayException("Array length must be greater then zero"));
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array)
                .max()
                .orElseThrow(() -> new CustomArrayException("Array length must be greater then zero"));
    }

    @Override
    public double findAvg(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array)
                .average()
                .orElseThrow(() -> new CustomArrayException("Array length must be greater then zero"));
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array).sum();
    }

    @Override
    public long findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array)
                .filter(x -> x >= 0)
                .count();
    }

    @Override
    public long findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array equals to null");
        }

        return createIntStream(array)
                .filter(x -> x < 0)
                .count();
    }

    private IntStream createIntStream(CustomArray array) {
        int[] intArray = array.toIntArray();
        return IntStream.of(intArray);
    }
}
