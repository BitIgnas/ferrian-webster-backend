package com.ferrianwebsterdictionary.app.demo.exception;

public class NoWordFoundInMeaningIndexException extends RuntimeException {
    public NoWordFoundInMeaningIndexException(String message) {
        super(message);
    }
}
