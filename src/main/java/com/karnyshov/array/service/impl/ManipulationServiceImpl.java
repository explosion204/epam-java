package com.karnyshov.array.service.impl;

import com.karnyshov.array.service.ManipulationService;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ManipulationServiceImpl implements ManipulationService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void replace(CustomArray array, Predicate<Integer> predicate,
                        UnaryOperator<Integer> transform) throws CustomArrayException {
        if (array == null || array.getLength() < 1) {
            String errorMsg = array == null ? "Array is null" : "Invalid array length " + array.getLength();
            throw new CustomArrayException(errorMsg);
        }

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);
            boolean isMatch = predicate.test(number);

            if (isMatch) {
                int oldNumber = array.get(i);
                int newNumber = transform.apply(oldNumber);
                array.set(i, newNumber);
                logger.debug("Value " + oldNumber + " is replaced with value " + newNumber);
            }
        }
    }
}
