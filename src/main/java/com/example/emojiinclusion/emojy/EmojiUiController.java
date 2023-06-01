package com.example.emojiinclusion.emojy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;

import java.util.stream.Collectors;

@Controller
public class EmojiUiController {

    private final EmojiApplicationService applicationService;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    public EmojiUiController(final EmojiApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public String fetchUI(Model model) {
        model.addAttribute("emojis", applicationService.fetchEmojis().stream().limit(6).map(Emoji::getStringValue)
                .collect(Collectors.joining ("")));

        var dataSourceUrlSubstring = dataSourceUrl.replace("jdbc:", "");
        model.addAttribute("database", dataSourceUrlSubstring.substring(0, dataSourceUrlSubstring.indexOf(":")).toUpperCase());
        return "index";
    }
}
