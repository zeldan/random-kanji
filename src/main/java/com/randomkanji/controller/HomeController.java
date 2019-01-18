package com.randomkanji.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.randomkanji.domain.JlptLevel;
import com.randomkanji.domain.Kanji;
import com.randomkanji.service.KanjiService;

@Controller
public class HomeController {

    @Autowired
    private KanjiService kanjiService;

    @GetMapping("/")
    public String index(Model model) {
        Kanji kanji = kanjiService.getKanjiBycategories(Collections.singletonList(JlptLevel.N5));
        model.addAttribute("kanji", kanji);
        return "index";
    }

}