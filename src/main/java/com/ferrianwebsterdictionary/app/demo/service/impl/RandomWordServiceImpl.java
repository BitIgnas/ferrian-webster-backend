package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.exception.NoWordFoundException;
import com.ferrianwebsterdictionary.app.demo.service.DictionaryService;
import com.ferrianwebsterdictionary.app.demo.service.RandomWordService;
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;
import com.github.dhiraj072.randomwordgenerator.datamuse.DataMuseRequest;
import com.github.dhiraj072.randomwordgenerator.exceptions.DataMuseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomWordServiceImpl implements RandomWordService {

    private final static Logger logger = LoggerFactory.getLogger(RandomWordServiceImpl.class);
    private final DictionaryService dictionaryService;

    public RandomWordServiceImpl(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @Override
    @Retryable(value = NoWordFoundException.class)
    public String generateRandomWord() {
        String randomWord = RandomWordGenerator.getRandomWord();
        return dictionaryService.getWordDefinition(randomWord).stream()
                .findFirst()
                .orElseThrow(() -> new NoWordFoundException(String.format("Word: %s was not found.", randomWord)))
                .getWord();
    }

    @Override
    @Retryable(value = NoWordFoundException.class)
    public String generateRandomWordWithTopics(List<String> topics) {
        DataMuseRequest dataMuseRequest = new DataMuseRequest().topics(topics.toArray(String[]::new));

        try {
            String randomWord = RandomWordGenerator.getRandomWord(dataMuseRequest);
            return dictionaryService.getWordDefinition(randomWord).stream()
                    .findFirst()
                    .orElseThrow(() -> new NoWordFoundException(String.format("Word: %s was not found.", randomWord)))
                    .getWord();
        } catch (DataMuseException e) {
            logger.error(e.getLocalizedMessage());
        }

        return null;
    }
}
