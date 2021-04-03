package com.karnyshov.array.parser;

import com.karnyshov.array.exception.CustomArrayException;

import java.util.stream.Stream;

public class CustomArrayParser {
    private final String SPLIT_PATTERN = "\\s+";

    public int[] parseString(String string) throws CustomArrayException {
        if (string == null) {
            String errorMsg = "Input string is null";
            throw new CustomArrayException(errorMsg);
        }

        String[] stringValues = string.split(SPLIT_PATTERN);

        try {
            return Stream.of(stringValues)
                    .mapToInt(Integer::decode)
                    .toArray();
        } catch (NumberFormatException e) {
            String errorMsg = "String " + string + " cannot be parsed due to invalid data";
            throw new CustomArrayException(errorMsg);
        }
    }
}
