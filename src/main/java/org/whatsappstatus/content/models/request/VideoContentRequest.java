package org.whatsappstatus.content.models.request;

import org.whatsappstatus.content.enums.ContentType;

public class VideoContentRequest extends ContentRequest {

    private String videoData; // Base64-encoded video data
    private String filename;
    private int durationInSeconds;

    public VideoContentRequest(ContentType contentType, String userId) {
        super(contentType, userId);
    }

    public String getVideoData() {
        return videoData;
    }

    public String getFilename() {
        return filename;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }
}
