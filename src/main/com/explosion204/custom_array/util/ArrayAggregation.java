package com.explosion204.custom_array.util;

import com.explosion204.custom_array.CustomArray;

public class ArrayAggregation {
    public static int findMin(CustomArray array) {
        CustomArray arrayCopy = array.getCopy();
        int arrayCopyLen = arrayCopy.getLength();

        ArrayManipulation.mergeSort(arrayCopy, arrayCopyLen);

        return arrayCopy.get(0);
    }

    public static int findMax(CustomArray array) {
        CustomArray arrayCopy = array.getCopy();
        int arrayCopyLen = arrayCopy.getLength();

        ArrayManipulation.mergeSort(arrayCopy, arrayCopyLen);

        return arrayCopy.get(arrayCopyLen - 1);
    }

    public static double findAvg(CustomArray array) {
        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return (double) sum / array.getLength();
    }

    public static long findSum(CustomArray array) {
        int sum = 0;

        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }

        return sum;
    }

    public static int findPositivesCount(CustomArray array) {
        int count = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);

            if (number >= 0) {
                count++;
            }
        }

        return count;
    }

    public static int findNegativesCount(CustomArray array) {
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
