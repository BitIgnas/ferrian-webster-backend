package com.ferrianwebsterdictionary.app.demo.model;

import java.util.List;

public class Meaning {
    private String partOfSpeech;
    private List<Word> words;

    public Meaning(String partOfSpeech, List<Word> words) {
        this.partOfSpeech = partOfSpeech;
        this.words = words;
    }

    public Meaning() {
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Word> getDefinitions() {
        return words;
    }

    public void setDefinitions(List<Word> words) {
        this.words = words;
    }
}
