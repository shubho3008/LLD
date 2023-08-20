package org.whatsappstatus.content.entities;

public class ImageContentEntity extends ContentEntity {


    private final String imageData; // Base64-encoded image data

    private final String filename;

    public ImageContentEntity(String imageData, String filename) {
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
