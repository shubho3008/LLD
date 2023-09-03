package org.whatsappstatus.content.models;

public class UploadPtr {
    private final String text;

    public UploadPtr(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "UploadPtr{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }
}
