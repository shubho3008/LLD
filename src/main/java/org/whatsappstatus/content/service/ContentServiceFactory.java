package org.whatsappstatus.content.service;

import org.whatsappstatus.content.enums.ContentType;

public interface ContentServiceFactory {
    ContentService createContentService(ContentType contentType);
}
