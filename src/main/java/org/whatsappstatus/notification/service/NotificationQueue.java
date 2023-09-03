package org.whatsappstatus.notification.service;


import org.whatsappstatus.notification.models.Notification;

public interface NotificationQueue {
    void enqueue(Notification notification) throws InterruptedException;

    Notification dequeue() throws InterruptedException;
}
