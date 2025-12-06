package com.aeerotech.digitallending.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class OllamaClient {

    @Value("${ollama.url}")
    private String url;

    @Value("${ollama.model}")
    private String model;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public String call(String prompt) {
        try {
            Map<String, Object> req = Map.of(
                "model", model,
                "prompt", prompt,
                "stream", false
            );

            String response = restTemplate.postForObject(url, req, String.class);
            return mapper.readTree(response).get("response").asText();
        } catch (Exception e) {
            return "LLM Error: " + e.getMessage();
        }
    }
}
