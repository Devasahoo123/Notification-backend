package com.Notificatin_System.observer;

import com.Notificatin_System.model.NotificationEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class NotificationObservable implements IObservable {
    private final List<IObserver> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(NotificationEvent event) {
        for (IObserver observer : observers) {
            observer.update(event);
        }
    }
}