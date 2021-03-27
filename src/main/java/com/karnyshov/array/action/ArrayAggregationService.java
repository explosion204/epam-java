package com.karnyshov.array.action;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;

public interface ArrayAggregationService {
    int findMin(CustomArray array) throws CustomArrayException;
    int findMax(CustomArray array) throws CustomArrayException;
    double findAvg(CustomArray array) throws CustomArrayException;
    long findSum(CustomArray array) throws CustomArrayException;
    int findPositivesCount(CustomArray array) throws CustomArrayException;
    int findNegativesCount(CustomArray array) throws CustomArrayException;
}
