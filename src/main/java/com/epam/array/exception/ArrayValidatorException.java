package com.epam.array.exception;

public class ArrayValidatorException extends Exception {

    public ArrayValidatorException() {
    }

    public ArrayValidatorException(String message) {
        super(message);
    }

    public ArrayValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayValidatorException(Throwable cause) {
        super(cause);
    }
}