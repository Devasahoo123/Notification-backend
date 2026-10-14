package com.Notificatin_System.model;

public class SimpleNotification implements INotification {
    private final String text;

    public SimpleNotification(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
}