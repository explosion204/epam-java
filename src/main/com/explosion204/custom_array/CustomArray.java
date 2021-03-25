package com.explosion204.custom_array;

import com.explosion204.custom_array.exception.ArrayInvalidIndexException;
import com.explosion204.custom_array.exception.ArrayInvalidLengthException;

public class CustomArray {
    private int[] internalCollection;
    private int length;

    public CustomArray(int length) {
        if (length < 1) {
            throw new ArrayInvalidLengthException();
        }

        internalCollection = new int[length];
        this.length = length;
    }

    public CustomArray(int ... values) {
        if (values.length < 1) {
            throw new ArrayInvalidLengthException();
        }

        internalCollection = values.clone();
        length = internalCollection.length;
    }

    public int getLength() {
        return length;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayInvalidIndexException();
        }

        return internalCollection[index];
    }

    public void set(int index, int number) {
        if (index < 0 || index >= length) {
            throw new ArrayInvalidIndexException();
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

        if (length != anotherArray.getLength()) {
            return false;
        }

        for (int i = 0; i < anotherArray.length; i++) {
            if (internalCollection[i] != anotherArray.get(i)) {
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