package org.whatsappstatus.notification.service.impl;

import org.whatsappstatus.notification.models.Notification;
import org.whatsappstatus.notification.service.NotificationQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationQueueImpl implements NotificationQueue {
    private final BlockingQueue<Notification> queue;

    private final String queueName;

    public NotificationQueueImpl(String queueName, int queueCapacity) {
        this.queueName = queueName;
        queue = new LinkedBlockingQueue<>(queueCapacity);
    }

    public void enqueue(Notification notification) throws InterruptedException {
        queue.put(notification);
    }

    public Notification dequeue() throws InterruptedException {
        return queue.take();
    }

}

