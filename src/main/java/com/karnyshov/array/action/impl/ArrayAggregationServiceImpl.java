package com.karnyshov.array.action.impl;

import com.karnyshov.array.action.ArrayAggregationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayAggregationServiceImpl implements ArrayAggregationService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findMin)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int min = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }

        logger.debug("Found min value: " + min);
        return min;
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findMax)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int max = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }

        logger.debug("Found max value: " + max);
        return max;
    }

    @Override
    public double findAvg(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findAvg)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        double avg = (double) sum / array.getLength();
        logger.debug("Found average value of array elements: " + avg);
        return avg;
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findSum)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        logger.debug("Found sum of array elements: " + sum);
        return sum;
    }

    @Override
    public int findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findPositivesCount)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number >= 0) {
                count++;
            }
        }

        logger.debug("Found " + count + " positive elements in array");
        return count;
    }

    @Override
    public int findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            logger.error("Array length is less than zero or equals to null (findNegativesCount)");
            throw new CustomArrayException("Array length must be greater then zero");
        }

        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number < 0) {
                count++;
            }
        }

        logger.debug("Found " + count + " negative elements in array");
        return count;
    }
}
