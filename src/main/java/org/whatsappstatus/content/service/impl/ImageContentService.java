package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.entities.ImageContentEntity;
import org.whatsappstatus.content.exceptions.UploadResponseException;
import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.content.models.request.ContentRequest;
import org.whatsappstatus.content.models.request.ImageContent;
import org.whatsappstatus.content.models.request.ImageContentRequest;
import org.whatsappstatus.content.models.response.UploadResponse;
import org.whatsappstatus.content.repository.ImageStorageImpl;
import org.whatsappstatus.content.service.ContentService;

public class ImageContentService extends ContentService {
    ImageStorageImpl imageStorage;

    public ImageContentService(UserContentBroadcastPublisher contentBroadcastPublisher, ImageStorageImpl imageStorage) {
        super(contentBroadcastPublisher);
        this.imageStorage = imageStorage;
    }


    @Override
    public UploadResponse uploadContent(ContentRequest contentRequest) throws UploadResponseException {
        try {
            UploadPtr uploadPtr = imageStorage.upload(convertToEntity(((ImageContentRequest) contentRequest).getContent()), contentRequest.getUserName());
            broadcastToContacts(contentRequest.getUserName(), uploadPtr);
            return new UploadResponse();
        } catch (Exception e) {
            throw new UploadResponseException();
        }
    }

    private ImageContentEntity convertToEntity(ImageContent content) {
        return new ImageContentEntity(content.getImageData(), content.getFilename());
    }

}
