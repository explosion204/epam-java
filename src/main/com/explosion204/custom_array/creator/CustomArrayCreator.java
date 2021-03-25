package com.explosion204.custom_array.creator;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.exception.CustomArrayException;

public interface CustomArrayCreator {
    CustomArray createEmptyArray(int length) throws CustomArrayException;
    CustomArray createArrayFromValues(int ... values);
}
