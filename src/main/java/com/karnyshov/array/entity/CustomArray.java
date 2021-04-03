package com.karnyshov.array.entity;

import com.karnyshov.array.exception.CustomArrayException;

public class CustomArray implements Cloneable {
    private int[] internalCollection;

    public CustomArray(int length) throws CustomArrayException {
        if (length < 0) {
            String errorMsg = "Invalid array length: " + length;
            throw new CustomArrayException(errorMsg);
        }

        internalCollection = new int[length];
    }

    public int getLength() {
        return internalCollection.length;
    }

    public int[] toIntArray() {
        return internalCollection.clone();
    }

    public int get(int index) throws CustomArrayException {
        if (index < 0 || index >= internalCollection.length) {
            String errorMsg = "Array index " + index + " is out of bounds";
            throw new CustomArrayException(errorMsg);
        }

        return internalCollection[index];
    }

    public void set(int index, int number) throws CustomArrayException {
        if (index < 0 || index >= internalCollection.length) {
            String errorMsg = "Array index " + index + " is out of bounds";
            throw new CustomArrayException(errorMsg);
        }

        internalCollection[index] = number;
    }

    @Override
    public CustomArray clone() throws CloneNotSupportedException {
        CustomArray arrayCopy = (CustomArray) super.clone();
        arrayCopy.internalCollection = internalCollection.clone();
        return arrayCopy;
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
        int anotherArrayLength = anotherArray.getLength();

        if (internalCollection.length != anotherArrayLength) {
            return false;
        }

        for (int i = 0; i < anotherArrayLength; i++) {
            if (internalCollection[i] != anotherArray.internalCollection[i]) {
                return false;
            }
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