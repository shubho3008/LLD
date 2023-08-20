package org.whatsappstatus.content.service.impl;

import org.whatsappstatus.content.models.request.UserContentBroadcastRequest;
import org.whatsappstatus.notification.service.NotificationQueue;

public class UserContentBroadcastConsumer implements Runnable {

    private final NotificationQueue notificationQueue;

    private final UserContentBroadcastManager userContentBroadcastManager;

    public UserContentBroadcastConsumer(NotificationQueue notificationQueue, UserContentBroadcastManager userContentBroadcastManager) {
        this.notificationQueue = notificationQueue;
        this.userContentBroadcastManager = userContentBroadcastManager;
    }

    @Override
    public void run() {
        try {
            while (true) {
                UserContentBroadcastRequest notification = (UserContentBroadcastRequest) notificationQueue.dequeue();
                System.out.println("Consumed: " + notification);
                userContentBroadcastManager.sendContent(notification.getUserName(), notification.getUploadPtr());

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
