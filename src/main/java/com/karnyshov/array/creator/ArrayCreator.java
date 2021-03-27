package com.karnyshov.array.creator;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

public interface ArrayCreator {
    CustomArray createFromFile(String filePath) throws CustomArrayException;
}
