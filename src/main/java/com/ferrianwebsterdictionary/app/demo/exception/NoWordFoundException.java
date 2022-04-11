package com.ferrianwebsterdictionary.app.demo.exception;

public class NoWordFoundException extends RuntimeException {
    public NoWordFoundException(String message) {
        super(message);
    }
}
