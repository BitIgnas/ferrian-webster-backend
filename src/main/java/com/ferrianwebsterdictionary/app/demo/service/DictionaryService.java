package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.DictionaryResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DictionaryService {
    ResponseEntity<DictionaryResponseDto[]> getWordDefinitionFromApi(String word, String url);

    List<DictionaryResponseDto> getWordDefinition(String word);

    List<DictionaryResponseDto> getWordDefinitionWithPartOfSpeech(String word, String partOfSpeech);

    DictionaryResponseDto getSelectMeaningOfWordDefinition(String word, Integer meaningNum);

    List<String> getAllWordSynonyms(String word);

    Map<Integer, DictionaryResponseDto> mapResponseToMeaningMap(List<DictionaryResponseDto> definitions);

    HttpEntity<String> createHttpEntity();
}
