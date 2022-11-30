package com.example.emojiinclusion.emojy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmojiApplicationService {

    private final EmojiRepository emojiRepository;

    public EmojiApplicationService(EmojiRepository emojiRepository) {
        this.emojiRepository = emojiRepository;
    }

    List<Emoji> fetchEmojis() {
        return emojiRepository.findAll();
    }

    void addRandomEmoji() {
        emojiRepository.save(Emoji.random());
    }
}
