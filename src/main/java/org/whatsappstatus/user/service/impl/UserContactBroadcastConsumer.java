package org.whatsappstatus.user.service.impl;

import org.whatsappstatus.notification.service.NotificationQueue;
import org.whatsappstatus.user.models.request.UserContactNotificationRequest;
import org.whatsappstatus.user.service.UserContactBroadcastManager;

public class UserContactBroadcastConsumer implements Runnable {

    private final NotificationQueue notificationQueue;

    private final UserContactBroadcastManager userContactBroadcastManager;

    public UserContactBroadcastConsumer(NotificationQueue notificationQueue, UserContactBroadcastManager userContactBroadcastManager) {
        this.notificationQueue = notificationQueue;
        this.userContactBroadcastManager = userContactBroadcastManager;
    }

    @Override
    public void run() {
        try {
            while (true) {
                UserContactNotificationRequest notification = (UserContactNotificationRequest) notificationQueue.dequeue();
                System.out.println("Consumed: " + notification);
                userContactBroadcastManager.updateBroadcastList(notification.getUsername());

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
