package com.example.emojiinclusion.emojy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Random;

@Entity
public class Emoji {

    @Id
    @GeneratedValue
    private Long id;

    private String stringValue;

    public Emoji() { }

    public Emoji(String value) {
        this.stringValue = value;
    }

    private static final List<String> gender = List.of("&#128104;","&#128105;");
    private static final List<String> colors = List.of("&#127999;","&#127998;","&#127997;","&#127996;","&#127995;");

    static Emoji random() {
        var random = new Random();
        var emojiValue = gender.get(random.nextInt(gender.size())) + colors.get(random.nextInt(colors.size()));
        return new Emoji(emojiValue);
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String value) {
        this.stringValue = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}