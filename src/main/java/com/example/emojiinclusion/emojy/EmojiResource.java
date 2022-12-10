package com.example.emojiinclusion.emojy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(EmojiResource.BASE_URI)
class EmojiResource {

    static final String BASE_URI = "/api/v1/emojis";

    private final EmojiApplicationService emojiApplicationService;

    EmojiResource(EmojiApplicationService emojiApplicationService) {
        this.emojiApplicationService = emojiApplicationService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<String>> fetchEmojis() {
        return ResponseEntity.ok(emojiApplicationService.fetchEmojis()
                .stream().map(Emoji::getStringValue).collect(Collectors.toList()));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> addRandomEmoji() {
        this.emojiApplicationService.addRandomEmoji();
        return ResponseEntity.noContent().build();
    }
}
