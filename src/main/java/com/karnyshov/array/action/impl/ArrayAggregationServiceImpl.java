package com.karnyshov.array.action.impl;

import com.karnyshov.array.action.ArrayAggregationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayAggregationServiceImpl implements ArrayAggregationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findMin)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        OptionalInt result = stream.min();

        if (result.isEmpty()) {
            logger.error("Array length is less than zero or equals to null (findMin)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int minValue = result.getAsInt();
        logger.debug("Found min value: " + minValue);
        return minValue;
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findMax)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        OptionalInt result = stream.max();

        if (result.isEmpty()) {
            logger.error("Array length is less than zero or equals to null (findMax)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int minValue = result.getAsInt();
        logger.debug("Found min value: " + minValue);
        return minValue;
    }

    @Override
    public double findAvg(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findAvg)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        OptionalDouble result = stream.average();

        if (result.isEmpty()) {
            logger.error("Array length is less than zero or equals to null (findAvg)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        double avgValue = result.getAsDouble();
        logger.debug("Found avg value: " + avgValue);
        return avgValue;
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findSum)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        int sum = stream.sum();
        logger.debug("Found sum of array elements: " + sum);
        return sum;
    }

    @Override
    public long findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findPositivesCount)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        stream = stream.filter(x -> x >= 0);
        long count = stream.count();

        logger.debug("Found " + count + " positive elements in array");
        return count;
    }

    @Override
    public long findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null) {
            logger.error("Array equals to null (findPositivesCount)");
            throw new CustomArrayException("Array cannot be null");
        }

        IntStream stream = createIntStream(array);
        stream = stream.filter(x -> x < 0);
        long count = stream.count();

        logger.debug("Found " + count + " negative elements in array");
        return count;
    }

    private IntStream createIntStream(CustomArray array) {
        int[] intArray = array.toIntArray();
        return IntStream.of(intArray);
    }
}
