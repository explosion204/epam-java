package com.explosion204.custom_array.creator.impl;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.creator.CustomArrayCreator;
import com.explosion204.custom_array.exception.CustomArrayException;

public class CustomArrayCreatorImpl implements CustomArrayCreator {
    @Override
    public CustomArray createEmptyArray(int length) throws CustomArrayException {
        if (length < 0) {
            throw new CustomArrayException("Array length must not be less than zero");
        }
        int[] values = new int[length];
        return new CustomArray(values);
    }

    @Override
    public CustomArray createArrayFromValues(int... values) {
        return new CustomArray(values);
    }
}
