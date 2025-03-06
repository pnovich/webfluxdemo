package com.example.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WebSocketService {
    @Autowired
    SimpMessagingTemplate template;
    public void sendMessage(String message) {
        System.out.println("sending message from service: " + message);
        template.convertAndSend("/topic/notification", message);
    }

}
