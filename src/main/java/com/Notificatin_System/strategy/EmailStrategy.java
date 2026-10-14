package com.Notificatin_System.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailStrategy implements INotificationStrategy {
    private final String emailId;

    public EmailStrategy(@Value("${notification.email.to}") String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String getChannel() {
        return "EMAIL";
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending Email Notification to: " + emailId + "\n" + content);
    }
}