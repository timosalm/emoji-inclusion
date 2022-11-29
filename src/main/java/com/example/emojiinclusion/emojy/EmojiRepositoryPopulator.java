package com.example.emojiinclusion.emojy;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmojiRepositoryPopulator implements ApplicationListener<ApplicationReadyEvent> {

    private final EmojiRepository emojiRepository;

    public EmojiRepositoryPopulator(EmojiRepository emojiRepository) {
        this.emojiRepository = emojiRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.emojiRepository.save(Emoji.random());
    }
}
