package com.ferrianwebsterdictionary.app.demo.dto;

import com.ferrianwebsterdictionary.app.demo.model.NounType;

public class CustomWordResponseDto {

    private String word;
    private String meaning;
    private String origin;
    private NounType nounType;

    public CustomWordResponseDto(String word, String meaning, String origin, NounType nounType) {
        this.word = word;
        this.meaning = meaning;
        this.origin = origin;
        this.nounType = nounType;
    }

    public CustomWordResponseDto() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public NounType getNounType() {
        return nounType;
    }

    public void setNounType(NounType nounType) {
        this.nounType = nounType;
    }
}
