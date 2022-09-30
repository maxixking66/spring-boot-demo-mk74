package com.maktabsharif.springbootdemo.exception;

public class EntityNotFoundRuntimeException extends RuntimeException {

    public EntityNotFoundRuntimeException(String message) {
        super(message);
    }
}
