package com.Notificatin_System.strategy;

public interface INotificationStrategy {
    String getChannel();
    void sendNotification(String content);
}