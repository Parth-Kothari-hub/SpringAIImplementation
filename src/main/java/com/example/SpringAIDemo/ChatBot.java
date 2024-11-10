package com.ai_project.AI_Project;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatBot{
    private final OllamaChatModel chatModel;

    public ChatBot(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }
}