package com.explosion204.custom_array.entity;

import com.explosion204.custom_array.entity.CustomArray;
import com.explosion204.custom_array.exception.CustomArrayException;

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
