package com.Notificatin_System.decorator;

import com.Notificatin_System.model.INotification;

public class SignatureDecorator extends INotificationDecorator {
    private final String signature;

    public SignatureDecorator(INotification notification, String signature) {
        super(notification);
        this.signature = signature;
    }

    @Override
    public String getContent() {
        return notification.getContent() + "\n-- " + signature;
    }
}