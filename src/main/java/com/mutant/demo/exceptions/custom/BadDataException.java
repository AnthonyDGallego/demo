package com.mutant.demo.exceptions.custom;

public class BadDataException extends RuntimeException {
    public BadDataException(String msg) {
        super(msg);
    }
}
