package com.Notificatin_System.controller;

import java.util.List;

public record NotificationRequest(String message, boolean timestamp, String signature, List<String> channels) {}