package com.notin.senglish.model;

public class Word {
    private String wordEnglish;
    private String wordMean;

    public Word(String wordEnglish, String wordMean) {
        this.wordEnglish = wordEnglish;
        this.wordMean = wordMean;
    }

    public String getWordEnglish() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish = wordEnglish;
    }

    public String getWordMean() {
        return wordMean;
    }

    public void setWordMean(String wordMean) {
        this.wordMean = wordMean;
    }
}
