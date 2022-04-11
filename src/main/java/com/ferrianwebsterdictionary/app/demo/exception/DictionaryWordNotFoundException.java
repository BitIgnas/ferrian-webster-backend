package com.ferrianwebsterdictionary.app.demo.exception;

public class DictionaryWordNotFoundException extends RuntimeException {
    public DictionaryWordNotFoundException(String message) {
        super(message);
    }
}
