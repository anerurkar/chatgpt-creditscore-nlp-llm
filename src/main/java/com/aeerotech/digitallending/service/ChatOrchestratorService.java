package com.aeerotech.digitallending.service;




import com.aeerotech.digitallending.model.ChatResponse;
import com.aeerotech.digitallending.model.CustomerScore;
import com.aeerotech.digitallending.prompt.PromptBuilder;
import org.springframework.stereotype.Service;

@Service
public class ChatOrchestratorService {

    private final CreditScoreService creditScoreService;
    private final OllamaClient ollamaClient;
    private final PromptBuilder promptBuilder;

    public ChatOrchestratorService(CreditScoreService c,
                                   OllamaClient o,
                                   PromptBuilder p) {
        this.creditScoreService = c;
        this.ollamaClient = o;
        this.promptBuilder = p;
    }

    public ChatResponse process(String customerId, String message) {
        CustomerScore score = creditScoreService.fetch(customerId);
        String prompt = promptBuilder.build(score);
        String llmReply = ollamaClient.call(prompt);

        return new ChatResponse(
            llmReply,
            promptBuilder.version(),
            "llama3:8b"
        );
    }
}
