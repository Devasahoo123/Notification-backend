package com.Notificatin_System.observer;

import com.Notificatin_System.model.NotificationEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class LoggerObserver implements IObserver {
    private final NotificationObservable observable;

    public LoggerObserver(NotificationObservable observable) {
        this.observable = observable;
    }

    @PostConstruct
    void register() {
        observable.addObserver(this);
    }

    @Override
    public void update(NotificationEvent event) {
        System.out.println("Logging New Notification " + event.channels() + ":\n"
                + event.notification().getContent());
    }
}