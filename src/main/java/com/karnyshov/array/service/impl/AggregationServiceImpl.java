package com.karnyshov.array.service.impl;

import com.karnyshov.array.service.AggregationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AggregationServiceImpl implements AggregationService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
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
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
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
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        double avg = (double) sum / array.getLength();
        logger.debug("Found avg value: " + avg);
        return avg;
    }

    @Override
    public long findSum(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
        }

        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        logger.debug("Found sum: " + sum);
        return sum;
    }

    @Override
    public long findPositivesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
        }

        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number >= 0) {
                count++;
            }
        }

        logger.debug("Found count of positive elements: " + count);
        return count;
    }

    @Override
    public long findNegativesCount(CustomArray array) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
        }

        long count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number < 0) {
                count++;
            }
        }

        logger.debug("Found count of negative elements: " + count);
        return count;
    }
}