package com.randomkanji.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.randomkanji.domain.JlptLevel;
import com.randomkanji.domain.Kanji;
import com.randomkanji.service.KanjiService;

@Controller
@RequiredArgsConstructor
public class KanjiController {

    private final KanjiService kanjiService;

    @GetMapping("/random")
    public String index(Model model, @RequestParam("categories") String categories) {
        List<JlptLevel> jlptLevels = mapToJlptCategories(categories);
        Kanji kanji = kanjiService.getKanjiBycategories(jlptLevels);
        model.addAttribute("kanji", kanji);
        return "index :: #kanjiBlock";
    }

    private List<JlptLevel> mapToJlptCategories(String categories) {
        if (!Strings.isEmpty(categories)) {
            return Arrays.asList(categories.split(",")).stream().map(category -> JlptLevel.valueOf(category)).collect(Collectors.toList());
        } else {
            return Arrays.asList(JlptLevel.values()).stream().collect(Collectors.toList());
        }
    }

}
