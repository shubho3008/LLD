package org.whatsappstatus.content.models.request;


import org.whatsappstatus.content.enums.ContentType;

public class ContentRequest {


    private final ContentType contentType;

    private final String userId;

    public ContentRequest(ContentType contentType, String userId) {
        this.contentType = contentType;
        this.userId = userId;
    }

    public String getUserName() {
        return userId;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public String getUserId() {
        return userId;
    }
}
