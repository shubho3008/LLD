package org.whatsappstatus.content.models.request;


public class TextContent extends Content {
    private final String text;

    public TextContent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
