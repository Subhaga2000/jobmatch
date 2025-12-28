package com.jobmatch;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ChatClient chatClient;

    // This connects our code to the AI
    public TestController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // This creates a web link: http://localhost:8080/test
    @GetMapping("/test")
    public String testAI() {
        return chatClient.prompt()
                .user("Tell me a funny joke about Java programmers.")
                .call()
                .content();
    }
}