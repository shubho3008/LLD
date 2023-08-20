package org.whatsappstatus.content.models.request;


public class ImageContent extends Content {
    private final String imageData; // Base64-encoded image data

    private final String filename;

    public ImageContent(String imageData, String filename) {
        this.imageData = imageData;
        this.filename = filename;
    }

    public String getImageData() {
        return imageData;
    }

    public String getFilename() {
        return filename;
    }
}
