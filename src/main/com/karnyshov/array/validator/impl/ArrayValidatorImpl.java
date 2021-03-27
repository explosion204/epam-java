package com.karnyshov.array.validator.impl;

import com.karnyshov.array.validator.ArrayValidator;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayValidatorImpl implements ArrayValidator {
    private final String SPLIT_PATTERN = "\\s+";

    @Override
    public int[] validate(String line) {
        ArrayList<Integer> integers = new ArrayList<>();
        String[] subStrings = line.split(SPLIT_PATTERN);

        for (String stringVal : subStrings) {
            try {
                Integer decodedVal = Integer.decode(stringVal);
                integers.add(decodedVal);
            } catch (NumberFormatException e) { }
        }

        Stream<Integer> integerStream = integers.stream();
        IntStream intStream = integerStream.mapToInt(x -> x);
        int[] resultValues = intStream.toArray();

        return resultValues;
    }
}
