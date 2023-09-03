package org.whatsappstatus.content.repository;

import org.whatsappstatus.content.entities.ContentEntity;
import org.whatsappstatus.content.entities.TextContentEntity;
import org.whatsappstatus.content.models.UploadPtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextStorageImpl implements Storage {

    Map<String, List<TextContentEntity>> textContentIndexedOnUserName = new HashMap<>();

    @Override
    public UploadPtr upload(ContentEntity contentEntityRequest, String userName) {
        List<TextContentEntity> textContentEntities;
        if (textContentIndexedOnUserName.containsKey(userName)) {
            textContentEntities = textContentIndexedOnUserName.get(userName);
        } else {
            textContentEntities = new ArrayList<>();
        }
        textContentEntities.add((TextContentEntity) contentEntityRequest);
        textContentIndexedOnUserName.put(userName, textContentEntities);
        return new UploadPtr(textContentEntities.toString());
    }
}
