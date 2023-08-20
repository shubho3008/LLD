package org.whatsappstatus.content.service;

import org.whatsappstatus.content.exceptions.UploadResponseException;
import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.content.models.request.ContentRequest;
import org.whatsappstatus.content.models.request.UserContentBroadcastRequest;
import org.whatsappstatus.content.models.response.UploadResponse;
import org.whatsappstatus.content.service.impl.UserContentBroadcastPublisher;

public abstract class ContentService {
    private final UserContentBroadcastPublisher contentBroadcastPublisher;

    public ContentService(UserContentBroadcastPublisher contentBroadcastPublisher) {
        this.contentBroadcastPublisher = contentBroadcastPublisher;
    }

    public abstract UploadResponse uploadContent(ContentRequest contentRequest) throws UploadResponseException;

    public void broadcastToContacts(String userName, UploadPtr uploadPtr) throws InterruptedException {
        contentBroadcastPublisher.publish(new UserContentBroadcastRequest(userName, uploadPtr));
    }
}
