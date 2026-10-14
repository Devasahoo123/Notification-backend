package com.Notificatin_System.observer;

import com.Notificatin_System.model.NotificationEvent;
import com.Notificatin_System.strategy.INotificationStrategy;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationEngine implements IObserver {
    private final NotificationObservable observable;
    private final List<INotificationStrategy> strategies;

    public NotificationEngine(NotificationObservable observable,
                              List<INotificationStrategy> strategies) {
        this.observable = observable;
        this.strategies = strategies;
    }

    @PostConstruct
    void register() {
        observable.addObserver(this);
    }

    @Override
    public void update(NotificationEvent event) {
        String content = event.notification().getContent();
        for (INotificationStrategy strategy : strategies) {
            if (event.channels().contains(strategy.getChannel())) {
                strategy.sendNotification(content);
            }
        }
    }
}