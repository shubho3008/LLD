package org.whatsappstatus.content.models.request;


import org.whatsappstatus.content.enums.ContentType;

public class TextContentRequest extends ContentRequest {

    private final TextContent content;

    public TextContentRequest(String userId, TextContent content) {
        super(ContentType.TEXT, userId);
        this.content = content;
    }

    public TextContent getContent() {
        return content;
    }
}
