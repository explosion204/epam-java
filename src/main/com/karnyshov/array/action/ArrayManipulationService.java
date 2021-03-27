package com.karnyshov.array.action;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ArrayManipulationService {
    void replace(CustomArray array, Predicate<Integer> predicate,
                 UnaryOperator<Integer> transform) throws CustomArrayException;
    void mergeSort(CustomArray array) throws CustomArrayException;
}
