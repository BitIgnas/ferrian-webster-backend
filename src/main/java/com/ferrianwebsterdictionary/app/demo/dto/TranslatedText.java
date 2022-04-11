package com.ferrianwebsterdictionary.app.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslatedText {
    private String translatedText;

    public TranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
