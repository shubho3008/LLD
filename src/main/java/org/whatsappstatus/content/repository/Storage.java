package org.whatsappstatus.content.repository;

import org.whatsappstatus.content.entities.ContentEntity;
import org.whatsappstatus.content.models.UploadPtr;

public interface Storage {
    UploadPtr upload(ContentEntity contentEntityRequest, String userName);
}
