package com.Notificatin_System.model;

import java.util.Set;

public record NotificationEvent(INotification notification, Set<String> channels) {}