package org.whatsappstatus.content.models.request;


import org.whatsappstatus.content.enums.ContentType;


public class ImageContentRequest extends ContentRequest {

    private final ImageContent content;

    public ImageContentRequest(String userId, ImageContent content) {
        super(ContentType.IMAGE, userId);
        this.content = content;
    }

    public ImageContent getContent() {
        return content;
    }
}
