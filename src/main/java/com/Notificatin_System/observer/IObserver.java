package com.Notificatin_System.observer;

import com.Notificatin_System.model.NotificationEvent;

public interface IObserver {
    void update(NotificationEvent event);
}