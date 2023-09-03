package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.exceptions.UploadResponseException;
import org.whatsappstatus.content.models.request.ContentRequest;
import org.whatsappstatus.content.models.response.UploadResponse;
import org.whatsappstatus.content.repository.VideoStorageImpl;
import org.whatsappstatus.content.service.ContentService;

public class VideoContentService extends ContentService {

    VideoStorageImpl videoStorage;

    public VideoContentService(UserContentBroadcastPublisher contentBroadcastPublisher, VideoStorageImpl videoStorage) {
        super(contentBroadcastPublisher);
        this.videoStorage = videoStorage;
    }


    @Override
    public UploadResponse uploadContent(ContentRequest contentRequest) throws UploadResponseException {
        return null;
    }
}
