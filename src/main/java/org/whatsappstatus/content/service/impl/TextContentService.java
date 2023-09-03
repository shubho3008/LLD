package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.entities.TextContentEntity;
import org.whatsappstatus.content.exceptions.UploadResponseException;
import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.content.models.request.ContentRequest;
import org.whatsappstatus.content.models.request.TextContent;
import org.whatsappstatus.content.models.request.TextContentRequest;
import org.whatsappstatus.content.models.response.UploadResponse;
import org.whatsappstatus.content.repository.Storage;
import org.whatsappstatus.content.service.ContentService;

public class TextContentService extends ContentService {
    private final Storage storage;

    public TextContentService(UserContentBroadcastPublisher contentBroadcastPublisher, Storage storage) {
        super(contentBroadcastPublisher);
        this.storage = storage;
    }


    @Override
    public UploadResponse uploadContent(ContentRequest contentRequest) throws UploadResponseException {
        try {
            UploadPtr uploadPtr = storage.upload(convertToEntity(((TextContentRequest) contentRequest).getContent()), contentRequest.getUserName());
            broadcastToContacts(contentRequest.getUserName(), uploadPtr);
            return new UploadResponse();
        } catch (Exception e) {
            throw new UploadResponseException();
        }
    }


    private TextContentEntity convertToEntity(TextContent content) {
        return new TextContentEntity(content.getText());
    }
}
