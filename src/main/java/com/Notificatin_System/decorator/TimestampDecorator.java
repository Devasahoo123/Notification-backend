package com.Notificatin_System.decorator;

import com.Notificatin_System.model.INotification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDecorator extends INotificationDecorator {
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TimestampDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[" + LocalDateTime.now().format(FMT) + "] " + notification.getContent();
    }
}