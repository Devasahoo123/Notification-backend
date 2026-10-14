package com.Notificatin_System.service;

import com.Notificatin_System.model.INotification;
import com.Notificatin_System.model.NotificationEvent;
import com.Notificatin_System.model.SimpleNotification;
import com.Notificatin_System.observer.NotificationObservable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class NotificationService {
    private final NotificationObservable observable;
    private final List<String> history = new CopyOnWriteArrayList<>();

    public NotificationService(NotificationObservable observable) {
        this.observable = observable;
    }

    public void sendNotification(INotification notification, Set<String> channels) {
        // Snapshot the content once so the timestamp is identical on every channel
        String content = notification.getContent();
        history.add(content);
        observable.notifyObservers(new NotificationEvent(new SimpleNotification(content), channels));
    }

    public List<String> getHistory() {
        return List.copyOf(history);
    }
}