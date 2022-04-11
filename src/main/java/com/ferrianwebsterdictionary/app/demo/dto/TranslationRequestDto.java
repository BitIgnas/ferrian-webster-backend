package com.ferrianwebsterdictionary.app.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationRequestDto {

    @JsonProperty("text")
    private String text;
    @JsonProperty("to")
    private String to;
    @JsonProperty("from")
    private String from;
    @JsonProperty("protectedWords")
    private String protectedWords;

    public TranslationRequestDto(String text, String to) {
        this.text = text;
        this.to = to;
    }

    public TranslationRequestDto(String text, String to, String from, String protectedWords) {
        this.text = text;
        this.to = to;
        this.from = from;
        this.protectedWords = protectedWords;
    }

    public TranslationRequestDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getProtectedWords() {
        return protectedWords;
    }

    public void setProtectedWords(String protectedWords) {
        this.protectedWords = protectedWords;
    }

    public static class Builder {
        private String text;
        private String to;
        private String from;
        private String protectedWords;

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder withLanguageTo(String to) {
            this.to = to;
            return this;
        }

        public Builder withLanguageFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder withProtectedWords(String protectedWords) {
            this.protectedWords = protectedWords;
            return this;
        }

        public TranslationRequestDto build() {
            return new TranslationRequestDto(this.text, this.to, this.from, this.protectedWords);
        }

    }
}
