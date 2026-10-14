package com.Notificatin_System.controller;

import com.Notificatin_System.decorator.SignatureDecorator;
import com.Notificatin_System.decorator.TimestampDecorator;
import com.Notificatin_System.model.INotification;
import com.Notificatin_System.model.SimpleNotification;
import com.Notificatin_System.service.NotificationService;
import com.Notificatin_System.strategy.PopUpStrategy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class NotificationController {
    private final NotificationService service;
    private final PopUpStrategy popUpStrategy;

    public NotificationController(NotificationService service, PopUpStrategy popUpStrategy) {
        this.service = service;
        this.popUpStrategy = popUpStrategy;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody NotificationRequest req) {
        if (req.message() == null || req.message().isBlank()) {
            return ResponseEntity.badRequest().body("Message is required");
        }
        if (req.channels() == null || req.channels().isEmpty()) {
            return ResponseEntity.badRequest().body("Select at least one channel");
        }

        INotification n = new SimpleNotification(req.message());
        if (req.timestamp()) {
            n = new TimestampDecorator(n);
        }
        if (req.signature() != null && !req.signature().isBlank()) {
            n = new SignatureDecorator(n, req.signature());
        }

        Set<String> channels = req.channels().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        service.sendNotification(n, channels);
        return ResponseEntity.ok("Sent to " + channels);
    }

    @GetMapping
    public List<String> history() {
        return service.getHistory();
    }

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream() {
        return popUpStrategy.subscribe();
    }
}