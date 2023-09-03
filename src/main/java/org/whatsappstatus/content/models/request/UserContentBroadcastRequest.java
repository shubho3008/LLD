package org.whatsappstatus.content.models.request;


import org.whatsappstatus.content.models.UploadPtr;
import org.whatsappstatus.notification.models.Notification;


public class UserContentBroadcastRequest extends Notification {

    private final String userName;
    private final UploadPtr uploadPtr;

    public UserContentBroadcastRequest(String userName, UploadPtr uploadPtr) {
        this.userName = userName;
        this.uploadPtr = uploadPtr;
    }

    @Override
    public String toString() {
        return "UserContentBroadcastRequest{" +
                "userName='" + userName + '\'' +
                ", uploadPtr=" + uploadPtr +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public UploadPtr getUploadPtr() {
        return uploadPtr;
    }
}
