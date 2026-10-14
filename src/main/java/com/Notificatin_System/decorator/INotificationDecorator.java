package com.Notificatin_System.decorator;

import com.Notificatin_System.model.INotification;

public abstract class INotificationDecorator implements INotification {
    protected final INotification notification;

    public INotificationDecorator(INotification notification) {
        this.notification = notification;
    }
}