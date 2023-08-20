package org.whatsappstatus.content.service;

import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.user.entities.UserProfileEntity;

public class ContentSender {

    public static void send(UserProfileEntity userProfileEntity, UploadPtr uploadPtr) {
        //TODO:Have a strategy defined to do push/pull send
        System.out.println("User " + userProfileEntity.getUsername() + " Recieved " + uploadPtr);
    }
}
