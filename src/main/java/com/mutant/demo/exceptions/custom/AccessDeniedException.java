package com.mutant.demo.exceptions.custom;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String msg) {
        super(msg);
    }
}
