package com.karnyshov.array.service;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

public interface AggregationService {
    int findMin(CustomArray array) throws CustomArrayException;
    int findMax(CustomArray array) throws CustomArrayException;
    double findAvg(CustomArray array) throws CustomArrayException;
    long findSum(CustomArray array) throws CustomArrayException;
    long findPositivesCount(CustomArray array) throws CustomArrayException;
    long findNegativesCount(CustomArray array) throws CustomArrayException;
}
