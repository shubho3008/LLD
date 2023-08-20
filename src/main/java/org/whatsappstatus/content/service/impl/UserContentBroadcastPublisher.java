package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.models.request.UserContentBroadcastRequest;
import org.whatsappstatus.notification.service.NotificationQueue;

public class UserContentBroadcastPublisher {

    private final NotificationQueue notificationQueue;

    public UserContentBroadcastPublisher(NotificationQueue notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public void publish(UserContentBroadcastRequest userContentBroadcastRequest) throws InterruptedException {
        notificationQueue.enqueue(userContentBroadcastRequest);
    }

}
