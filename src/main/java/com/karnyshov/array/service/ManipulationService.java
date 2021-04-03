package com.karnyshov.array.service;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ManipulationService {
    void replace(CustomArray array, Predicate<Integer> predicate,
                 UnaryOperator<Integer> transform) throws CustomArrayException;
}
