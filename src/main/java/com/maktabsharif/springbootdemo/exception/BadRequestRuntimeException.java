package com.maktabsharif.springbootdemo.exception;

public class BadRequestRuntimeException extends RuntimeException {

    public BadRequestRuntimeException(String message) {
        super(message);
    }
}
