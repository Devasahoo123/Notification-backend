package com.Notificatin_System.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SMSStrategy implements INotificationStrategy {
    private final String mobileNumber;

    public SMSStrategy(@Value("${notification.sms.to}") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String getChannel() {
        return "SMS";
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
    }
}