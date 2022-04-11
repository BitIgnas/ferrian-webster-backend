package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.DictionaryResponseDto;
import com.ferrianwebsterdictionary.app.demo.errorHandler.ApiDictionaryRestTemplateResponseErrorHandler;
import com.ferrianwebsterdictionary.app.demo.exception.NoWordFoundInMeaningIndexException;
import com.ferrianwebsterdictionary.app.demo.model.Word;
import com.ferrianwebsterdictionary.app.demo.model.Meaning;
import com.ferrianwebsterdictionary.app.demo.service.DictionaryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public DictionaryServiceImpl(RestTemplate restTemplate, RestTemplateBuilder restTemplateBuilder, Environment environment) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new ApiDictionaryRestTemplateResponseErrorHandler())
                .build();
        this.environment = environment;
    }

    @Override
    public ResponseEntity<DictionaryResponseDto[]> getWordDefinitionFromApi(String word, String url) {
        return restTemplate.exchange(
                Objects.requireNonNull(url).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                DictionaryResponseDto[].class
        );

    }

    @Override
    public List<DictionaryResponseDto> getWordDefinition(String word) {
        ResponseEntity<DictionaryResponseDto[]> response =
                getWordDefinitionFromApi(word, environment.getProperty("api.dictionary.url"));

        return List.of(Objects.requireNonNull(response.getBody()));
    }


    @Override
    public List<DictionaryResponseDto> getWordDefinitionWithPartOfSpeech(String word, String partOfSpeech) {
        ResponseEntity<DictionaryResponseDto[]> response =
                getWordDefinitionFromApi(word, environment.getProperty("api.dictionary.url"));

        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .filter(wordMeaning -> wordMeaning.getMeanings().stream()
                        .anyMatch(part -> part.getPartOfSpeech().equals(partOfSpeech)))
                .collect(Collectors.toList());
    }

    @Override
    public DictionaryResponseDto getSelectMeaningOfWordDefinition(String word, Integer meaningNum) {
        ResponseEntity<DictionaryResponseDto[]> response = getWordDefinitionFromApi(word, environment.getProperty("api.dictionary.url"));
        Map<Integer, DictionaryResponseDto> wordMeaningMap = mapResponseToMeaningMap(List.of(Objects.requireNonNull(response.getBody())));

        return Optional.ofNullable(wordMeaningMap.get(meaningNum)).orElseThrow(() ->
                new NoWordFoundInMeaningIndexException(String.format("Word: %s doesn't have meaning at index: %d", word, meaningNum)));
    }

    @Override
    public List<String> getAllWordSynonyms(String word) {
        ResponseEntity<DictionaryResponseDto[]> response = getWordDefinitionFromApi(word, environment.getProperty("api.dictionary.url"));

        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .map(DictionaryResponseDto::getMeanings).flatMap(Collection::stream)
                .map(Meaning::getDefinitions).flatMap(Collection::stream)
                .map(Word::getSynonyms).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, DictionaryResponseDto> mapResponseToMeaningMap(List<DictionaryResponseDto> definitions) {
        Map<Integer, DictionaryResponseDto> definitionMap = new HashMap<>();
        AtomicInteger count = new AtomicInteger(0);

        definitions.forEach(def -> {
            definitionMap.put(count.incrementAndGet(), def);
        });

        return definitionMap;
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setAllow(Set.of(HttpMethod.GET));

        return new HttpEntity<>(httpHeaders);
    }

}
