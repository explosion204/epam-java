package com.explosion204.custom_array;

import com.explosion204.custom_array.exception.ArrayInvalidIndexException;

public class CustomArray {
    private int[] internalCollection;

    public CustomArray() {
        internalCollection = new int[0];
    }

    public CustomArray(int ... values) {
        internalCollection = values.clone();
    }

    public int getLength() {
        return internalCollection.length;
    }

    public int get(int index) {
        if (index < 0 || index >= internalCollection.length) {
            throw new ArrayInvalidIndexException();
        }

        return internalCollection[index];
    }

    public void set(int index, int number) {
        if (index < 0 || index >= internalCollection.length) {
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
        int length = internalCollection.length;

        if (length != anotherArray.getLength()) {
            return false;
        }

        for (int i = 0; i < anotherArray.getLength(); i++) {
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