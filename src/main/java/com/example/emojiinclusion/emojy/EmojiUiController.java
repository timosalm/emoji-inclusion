package com.example.emojiinclusion.emojy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class EmojiUiController {

    private final EmojiApplicationService applicationService;

    public EmojiUiController(final EmojiApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public String fetchUI(Model model) {
        model.addAttribute("emojis", applicationService.fetchEmojis().stream().map(Emoji::getStringValue)
                .collect(Collectors.joining ("")));
        return "index";
    }
}
