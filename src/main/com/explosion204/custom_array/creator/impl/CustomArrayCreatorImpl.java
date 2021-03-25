package com.explosion204.custom_array.creator.impl;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.creator.CustomArrayCreator;

public class CustomArrayCreatorImpl implements CustomArrayCreator {
    @Override
    public CustomArray createEmptyArray(int length) {
        int[] values = new int[10];
        return new CustomArray(values);
    }

    @Override
    public CustomArray createArrayFromValues(int... values) {
        return new CustomArray(values);
    }
}
