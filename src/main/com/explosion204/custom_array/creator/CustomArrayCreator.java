package com.explosion204.custom_array.creator;

import com.explosion204.custom_array.CustomArray;

public interface CustomArrayCreator {
    CustomArray createEmptyArray(int length);
    CustomArray createArrayFromValues(int ... values);
}
