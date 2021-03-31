package com.karnyshov.array.action.impl;

import com.karnyshov.array.action.ArrayAggregationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class ArrayAggregationServiceImpl implements ArrayAggregationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findMin)");
            throw new CustomArrayException("Array cannot be null");
        }

        return createIntStream(array)
                .min()
                .orElseThrow(() -> {
                    logger.error("Array length is less than zero or equals to null (findMin)");
                    return new CustomArrayException("Array length must be greater then zero");
                });
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findMax)");
            throw new CustomArrayException("Array cannot be null");
        }

        return createIntStream(array)
                .max()
                .orElseThrow(() -> {
                    logger.error("Array length is less than zero or equals to null (findMax)");
                    return new CustomArrayException("Array length must be greater then zero");
                });
    }

    @Override
    public double findAvg(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findAvg)");
            throw new CustomArrayException("Array cannot be null");
        }

        return createIntStream(array)
                .average()
                .orElseThrow(() -> {
                    logger.error("Array length is less than zero or equals to null (findAvg)");
                    return new CustomArrayException("Array length must be greater then zero");
                });
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findSum)");
            throw new CustomArrayException("Array cannot be null");
        }

        return createIntStream(array).sum();
    }

    @Override
    public long findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findPositivesCount)");
            throw new CustomArrayException("Array cannot be null");
        }

        return createIntStream(array)
                .filter(x -> x >= 0)
                .count();
    }

    @Override
    public long findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findPositivesCount)");
            throw new CustomArrayException("Array cannot be null");
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
