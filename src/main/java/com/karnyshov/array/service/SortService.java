package com.karnyshov.array.service;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

public interface SortService {
    void sort(CustomArray array) throws CustomArrayException;
}
