package com.ferrianwebsterdictionary.app.demo.model;

public enum Language {
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    AMHARIC("am");

    private final String prefix;

    Language(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }
}
