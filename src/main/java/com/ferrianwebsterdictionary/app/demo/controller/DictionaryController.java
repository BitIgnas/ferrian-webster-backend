package com.ferrianwebsterdictionary.app.demo.controller;

import com.ferrianwebsterdictionary.app.demo.dto.DictionaryResponseDto;
import com.ferrianwebsterdictionary.app.demo.service.DictionaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v2/word")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping(value = "/entry/{word}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DictionaryResponseDto>> getWordDefinition(@PathVariable("word") String word) {
        return ResponseEntity.ok().body(dictionaryService.getWordDefinition(word));
    }

    @GetMapping(value = "/entry/{word}/{partOfSpeech}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DictionaryResponseDto>> getWordDefinitionsWithPartOfSpeech(@PathVariable("word") String word,
                                                                                          @PathVariable("partOfSpeech") String partOfSpeech) {
        return ResponseEntity.ok().body(dictionaryService.getWordDefinitionWithPartOfSpeech(word, partOfSpeech));
    }

    @GetMapping(value = "/entry/{word}/definition/{meaning}")
    public ResponseEntity<DictionaryResponseDto> getWordDefinitionByMeaningNumber(@PathVariable("word") String word,
                                                                                  @PathVariable("meaning") String meanings) {
        return ResponseEntity.ok().body(dictionaryService.getSelectMeaningOfWordDefinition(word, Integer.parseInt(meanings)));
    }

    @GetMapping(value = "/entry/{word}/synonyms", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getWordSynonyms(@PathVariable("word") String word) {
        return ResponseEntity.ok().body(dictionaryService.getAllWordSynonyms(word));
    }

}
