package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.exception.NoWordFoundException;
import org.springframework.retry.annotation.Retryable;

import java.util.List;

public interface RandomWordService {

    @Retryable(value = NoWordFoundException.class)
    String generateRandomWord();

    @Retryable(value = NoWordFoundException.class)
    String generateRandomWordWithTopics(List<String> topics);
}
