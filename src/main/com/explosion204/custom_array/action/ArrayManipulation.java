package com.explosion204.custom_array.action;

import com.explosion204.custom_array.CustomArray;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayManipulation {
    public static void replace(CustomArray array, Predicate<Integer> predicate,
        UnaryOperator<Integer> transform) {
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

    public static void mergeSort(CustomArray array, int len) {
        if (len < 2) {
            return;
        }

        int mid = len / 2;
        CustomArray leftArr = new CustomArray(mid);
        CustomArray rightArr = new CustomArray(len - mid);

        for (int i = 0; i < mid; i++) {
            int number = array.get(i);
            leftArr.set(i, number);
        }

        for (int i = mid; i < len; i++) {
            int number = array.get(i);
            rightArr.set(i - mid, number);
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, len - mid);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < mid && j < len - mid) {
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

        while (i < mid) {
            int number = leftArr.get(i);
            array.set(k, number);
            k++;
            i++;
        }

        while (j < len - mid) {
            int number = rightArr.get(j);
            array.set(k, number);
            k++;
            j++;
        }
    }
}
