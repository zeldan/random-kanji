package com.randomkanji.domain;

public class Kanji {

    private final String character;

    private final String onyomi;

    private final String kunyomi;

    private final String meaning;

    private final String category;

    public Kanji(String character, String onyomi, String kunyomi, String meaning, String category) {
        this.character = character;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.category = category;
    }

    public String getCharacter() {
        return character;
    }

    public String getOnyomi() {
        return onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Kanji [character=" + character + ", onyomi=" + onyomi + ", kunyomi=" + kunyomi + ", meaning=" + meaning
                + ", category=" + category + "]";
    }

}
