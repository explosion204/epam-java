package com.karnyshov.array.entity;

import com.karnyshov.array.exception.CustomArrayException;

public class CustomArrayCreator {
    public CustomArray createEmptyArray(int length) throws CustomArrayException {
        if (length < 0) {
            throw new CustomArrayException("Array length must not be less than zero");
        }

        int[] values = new int[length];
        return new CustomArray(values);
    }

    public CustomArray createArrayFromValues(int... values) {
        return new CustomArray(values);
    }
}
