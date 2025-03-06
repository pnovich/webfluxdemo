package com.example.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class WebSocketController {
//    @Autowired
//    private SimpMessagingTemplate template;
    @Autowired
    WebSocketService webSocketService;
    @MessageMapping("/note")
    public void sendMessage(String message) {
        System.out.println("sending message from controller: " + message);
        webSocketService.sendMessage(message);
    }

}
