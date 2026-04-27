package com.nutribalance.controller;

import com.nutribalance.model.ChatMessage;
import com.nutribalance.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // ✅ WEBSOCKET (STOMP)
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return chatService.saveMessage(message);
    }

    // ✅ REST API (History)
    @GetMapping("/history")
    public List<ChatMessage> getChatHistory() {
        return chatService.getChatHistory();
    }
}