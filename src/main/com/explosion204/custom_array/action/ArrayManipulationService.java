package com.explosion204.custom_array.action;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.exception.CustomArrayException;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ArrayManipulationService {
    void replace(CustomArray array, Predicate<Integer> predicate,
                 UnaryOperator<Integer> transform) throws CustomArrayException;
    void mergeSort(CustomArray array) throws CustomArrayException;
}
