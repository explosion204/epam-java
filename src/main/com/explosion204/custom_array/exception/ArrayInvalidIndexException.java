package com.explosion204.custom_array.exception;

public class ArrayInvalidIndexException extends RuntimeException {
    public ArrayInvalidIndexException() {
        super(Constants.INVALID_INDEX_ERROR_MSG);
    }
}
