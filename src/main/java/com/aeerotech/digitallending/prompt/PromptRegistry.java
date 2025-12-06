package com.aeerotech.digitallending.prompt;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Component
public class PromptRegistry {

    private final Map<String, String> registry = new HashMap<>();

    @PostConstruct
    public void loadPrompts() {
        try {
            ClassPathResource resource =
                new ClassPathResource("prompts/credit-score-nlp-v1.0.prompt");
            String content = Files.readString(resource.getFile().toPath());
            registry.put("credit-score-nlp-v1.0", content);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load prompts", e);
        }
    }

    public String getPrompt(String key) {
        return registry.get(key);
    }
}
