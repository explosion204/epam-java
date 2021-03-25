package com.explosion204.custom_array.action.impl;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.action.ArrayAggregationService;

public class ArrayAggregationServiceImpl implements ArrayAggregationService {
    @Override
    public int findMin(CustomArray array) {
        int min = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }

        return min;
    }

    @Override
    public int findMax(CustomArray array) {
        int max = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }

        return max;
    }

    @Override
    public double findAvg(CustomArray array) {
        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return (double) sum / array.getLength();
    }

    @Override
    public long findSum(CustomArray array) {
        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return sum;
    }

    @Override
    public int findPositivesCount(CustomArray array) {
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
    public int findNegativesCount(CustomArray array) {
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
