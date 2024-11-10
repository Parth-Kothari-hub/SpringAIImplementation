package com.example.SpringAIDemo.Services;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {
    private final OllamaChatModel chatModel;

    public ChatBotService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }
}
