package com.mutant.demo.exceptions.custom;

public class UniqueConstraintViolationException extends RuntimeException {
    public UniqueConstraintViolationException(String msg) {
        super(msg);
    }
}
