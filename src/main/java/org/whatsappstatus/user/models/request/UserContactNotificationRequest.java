package org.whatsappstatus.user.models.request;


import org.whatsappstatus.notification.models.Notification;


public class UserContactNotificationRequest extends Notification {

    private final String username;

    public UserContactNotificationRequest(String username) {
        super();
        this.username = username;
    }


    @Override
    public String toString() {
        return "UserContactNotificationRequest{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }
}
