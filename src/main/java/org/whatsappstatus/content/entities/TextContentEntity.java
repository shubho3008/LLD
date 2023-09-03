package org.whatsappstatus.content.entities;

public class TextContentEntity extends ContentEntity {
    private final String text;


    public TextContentEntity(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextContentEntity{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }
}
