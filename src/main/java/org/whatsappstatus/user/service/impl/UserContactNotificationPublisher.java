package org.whatsappstatus.user.service.impl;

import org.whatsappstatus.notification.service.NotificationQueue;
import org.whatsappstatus.user.models.request.UserContactNotificationRequest;

public class UserContactNotificationPublisher {


    private final NotificationQueue notificationQueue;

    public UserContactNotificationPublisher(NotificationQueue notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public void publishContactUpdateNotification(UserContactNotificationRequest userContactNotificationRequest) throws InterruptedException {
        notificationQueue.enqueue(userContactNotificationRequest);
    }

}
