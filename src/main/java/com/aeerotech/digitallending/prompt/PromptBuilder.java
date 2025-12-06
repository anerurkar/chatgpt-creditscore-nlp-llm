package com.aeerotech.digitallending.prompt;



import com.aeerotech.digitallending.model.CustomerScore;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    private final PromptRegistry registry;

    public PromptBuilder(PromptRegistry registry) {
        this.registry = registry;
    }

    public String build(CustomerScore score) {
        String template = registry.getPrompt("credit-score-nlp-v1.0");

        return template.replace("{{customerId}}", score.getCustomerId())
            .replace("{{creditScore}}", String.valueOf(score.getCreditScore()))
            .replace("{{fraudScore}}", String.valueOf(score.getFraudScore()));
    }

    public String version() {
        return "credit-score-nlp-v1.0";
    }
}
