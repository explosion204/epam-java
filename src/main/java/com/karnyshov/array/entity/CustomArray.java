package com.karnyshov.array.entity;

import com.karnyshov.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray {
    private static Logger logger = LogManager.getLogger();
    private final int[] internalCollection;

    private CustomArray() {
        internalCollection = new int[0];
    }

    private CustomArray(int ... values) {
        internalCollection = values.clone();
    }

    public int getLength() {
        return internalCollection.length;
    }

    public static CustomArray createEmptyArray(int length) throws CustomArrayException {
        if (length < 0) {
            logger.error("Negative array length");
            throw new CustomArrayException("Array length must not be less than zero");
        }

        int[] values = new int[length];
        return new CustomArray(values);
    }

    public static CustomArray createArrayFromValues(int... values) {
        return new CustomArray(values);
    }

    public int get(int index) throws CustomArrayException {
        if (index < 0 || index >= internalCollection.length) {
            String errorMsg = "Array index is out of bounds";
            logger.error(errorMsg);
            throw new CustomArrayException(errorMsg);
        }

        return internalCollection[index];
    }

    public void set(int index, int number) throws CustomArrayException {
        if (index < 0 || index >= internalCollection.length) {
            String errorMsg = "Array index is out of bounds";
            logger.error(errorMsg);
            throw new CustomArrayException(errorMsg);
        }

        internalCollection[index] = number;
    }

    public CustomArray getCopy() {
        return new CustomArray(internalCollection.clone());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        for (int number : internalCollection) {
            result = result * prime + number;
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CustomArray)) {
            return false;
        }

        CustomArray anotherArray = (CustomArray) obj;

        try {
            for (int i = 0; i < anotherArray.getLength(); i++) {
                if (internalCollection[i] != anotherArray.get(i)) {
                    return false;
                }
            }
        } catch (CustomArrayException e) {
            // exception is caught in case of different lengths
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        var stringRepresentation = new StringBuilder("{ ");

        for (int number : internalCollection) {
            stringRepresentation.append(number);
            stringRepresentation.append(" ");
        }

        stringRepresentation.append("}");
        return stringRepresentation.toString();
    }
}