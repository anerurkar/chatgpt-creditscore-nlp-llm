package com.aeerotech.digitallending.service;

import com.aeerotech.digitallending.model.CustomerScore;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditScoreService {

    private final RestTemplate restTemplate = new RestTemplate();

    public CustomerScore fetch(String customerId) {
        return restTemplate.getForObject(
            "http://localhost:8080/api/internal/scores/" + customerId,
            CustomerScore.class
        );
    }
}
