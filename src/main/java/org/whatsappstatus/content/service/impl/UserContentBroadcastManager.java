package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.content.service.ContentSender;
import org.whatsappstatus.user.entities.UserProfileEntity;
import org.whatsappstatus.user.repository.UserContactBroadcastRepository;

import java.util.List;

public class UserContentBroadcastManager {

    private final UserContactBroadcastRepository userContactBroadcastRepository;

    public UserContentBroadcastManager(UserContactBroadcastRepository userContactBroadcastRepository) {
        this.userContactBroadcastRepository = userContactBroadcastRepository;
    }

    public void sendContent(String userName, UploadPtr uploadPtr) {
        List<UserProfileEntity> userProfileEntities = userContactBroadcastRepository.get(userName);
        for (UserProfileEntity userProfileEntity : userProfileEntities) {
            ContentSender.send(userProfileEntity, uploadPtr);
        }
    }
}
