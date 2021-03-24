package com.explosion204.custom_array.exception;

public class ArrayInvalidLengthException extends RuntimeException {
    public ArrayInvalidLengthException() {
        super(Constants.INVALID_LENGTH_ERROR_MSG);
    }
}
