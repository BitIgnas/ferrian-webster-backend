package com.ferrianwebsterdictionary.app.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferrianwebsterdictionary.app.demo.model.Meaning;
import com.ferrianwebsterdictionary.app.demo.model.Phonetic;

import java.util.List;

public class DictionaryResponseDto {

    @JsonProperty("word")
    private String word;
    @JsonProperty("phonetic")
    private String phonetic;
    @JsonProperty("phonetics")
    private List<Phonetic> phonetics;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("meanings")
    private List<Meaning> meanings;

    public DictionaryResponseDto() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}

