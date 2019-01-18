package com.randomkanji.controller;

import java.util.ArrayList;
import java.util.List;

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
public class KanjiController {

    @Autowired
    private KanjiService kanjiService;

    @GetMapping("/random")
    public String index(Model model, @RequestParam("categories") String categories) {
        List<JlptLevel> jlptLevels = mapToJlptCategories(categories);
        Kanji kanji = kanjiService.getKanjiBycategories(jlptLevels);
        model.addAttribute("kanji", kanji);
        return "index :: #kanjiBlock";
    }

    private List<JlptLevel> mapToJlptCategories(String categories) {
        List<JlptLevel> jlptCategories = new ArrayList<>();
        if (!Strings.isEmpty(categories)) {
            for (String category : categories.split(",")) {
                jlptCategories.add(JlptLevel.valueOf(category));
            }
        } else {
            for (JlptLevel jlptLevel : JlptLevel.values()) {
                jlptCategories.add(jlptLevel);
            }
        }
        return jlptCategories;
    }

}
