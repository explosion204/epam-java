package com.karnyshov.array.creator;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

public class CustomArrayCreator {
    public CustomArray createFromValues(int ... values) throws CustomArrayException {
        CustomArray array = new CustomArray(values.length);

        for (int i = 0; i < values.length; i++) {
            array.set(i, values[i]);
        }

        return array;
    }
}
