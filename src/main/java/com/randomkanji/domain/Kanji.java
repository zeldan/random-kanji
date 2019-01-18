package com.randomkanji.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Kanji {

    private final String character;
    private final String onyomi;
    private final String kunyomi;
    private final String meaning;
    private final String category;

}
