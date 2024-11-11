package com.example.SpringAIDemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringAIDemo.Services.ChatBotService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/ai")
@RestController
public class ChatBotController {

    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @GetMapping("/ask")
    public String getResponse(@RequestParam String prompt) {
        return chatBotService.getResponse(prompt);
    }
}
