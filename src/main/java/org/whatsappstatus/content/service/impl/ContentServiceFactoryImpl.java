package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.enums.ContentType;
import org.whatsappstatus.content.repository.ImageStorageImpl;
import org.whatsappstatus.content.repository.TextStorageImpl;
import org.whatsappstatus.content.repository.VideoStorageImpl;
import org.whatsappstatus.content.service.ContentService;
import org.whatsappstatus.content.service.ContentServiceFactory;
import org.whatsappstatus.notification.service.NotificationQueue;

public class ContentServiceFactoryImpl implements ContentServiceFactory {
    private final NotificationQueue notificationQueue;

    public ContentServiceFactoryImpl(NotificationQueue notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public ContentService createContentService(ContentType contentType) {
        ContentService contentService;
        UserContentBroadcastPublisher contentBroadcastPublisher = new UserContentBroadcastPublisher(notificationQueue);
        switch (contentType) {
            case TEXT:
                contentService = new TextContentService(contentBroadcastPublisher, new TextStorageImpl());
                break;
            case IMAGE:
                contentService = new ImageContentService(contentBroadcastPublisher, new ImageStorageImpl());
                break;
            case VIDEO:
                contentService = new VideoContentService(contentBroadcastPublisher, new VideoStorageImpl());
                break;
            default:
                throw new IllegalArgumentException("Unsupported content type");
        }
        return contentService;
    }
}


