package com.aeerotech.digitallending.controller;

import com.aeerotech.digitallending.model.ChatRequest;
import com.aeerotech.digitallending.model.ChatResponse;
import com.aeerotech.digitallending.service.ChatOrchestratorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatOrchestratorService orchestrator;

    public ChatController(ChatOrchestratorService orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping("/message")
    public ChatResponse chat(@RequestHeader("X-Customer-Id") String customerId,
                             @RequestBody ChatRequest request) {
        return orchestrator.process(customerId, request.getMessage());
    }
}
