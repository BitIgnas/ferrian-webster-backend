package com.ferrianwebsterdictionary.app.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationResponseDto {

    @JsonProperty("from")
    private String from;
    @JsonProperty("original_text")
    private String originalText;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("to")
    private String to;
    @JsonProperty("translated_characters")
    private Integer translatedCharacters;
    @JsonProperty("translated_text")
    private String translatedText;

    public TranslationResponseDto(String from, String originalText, Integer status, String to, Integer translatedCharacters, String translatedText) {
        this.from = from;
        this.originalText = originalText;
        this.status = status;
        this.to = to;
        this.translatedCharacters = translatedCharacters;
        this.translatedText = translatedText;
    }

    public TranslationResponseDto() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getTranslatedCharacters() {
        return translatedCharacters;
    }

    public void setTranslatedCharacters(Integer translatedCharacters) {
        this.translatedCharacters = translatedCharacters;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
