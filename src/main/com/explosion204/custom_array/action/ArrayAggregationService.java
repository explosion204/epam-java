package com.explosion204.custom_array.action;

import com.explosion204.custom_array.CustomArray;

public interface ArrayAggregationService {
    int findMin(CustomArray array);
    int findMax(CustomArray array);
    double findAvg(CustomArray array);
    long findSum(CustomArray array);
    int findPositivesCount(CustomArray array);
    int findNegativesCount(CustomArray array);
}
