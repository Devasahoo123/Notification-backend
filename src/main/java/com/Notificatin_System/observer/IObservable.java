package com.Notificatin_System.observer;

import com.Notificatin_System.model.NotificationEvent;

public interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers(NotificationEvent event);
}