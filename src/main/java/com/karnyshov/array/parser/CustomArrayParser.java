package com.karnyshov.array.parser;

import com.karnyshov.array.exception.CustomArrayException;

import java.util.stream.Stream;

public class CustomArrayParser {
    private static final String SPLIT_PATTERN = "\\s+";

    public int[] parseString(String string) throws CustomArrayException {
        if (string == null) {
            throw new CustomArrayException("Input string is null");
        }

        String[] stringValues = string.split(SPLIT_PATTERN);

        try {
            return Stream.of(stringValues)
                    .mapToInt(Integer::decode)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new CustomArrayException("String " + string + " cannot be parsed due to invalid data");
        }
    }
}
