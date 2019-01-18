package com.randomkanji.domain;

public enum JlptLevel {

    N5("jlptn5"), N4("jlptn4"), N3("jlptn3"), N2("jlptn2"), N1("jlptn1");

    private String name;

    JlptLevel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
