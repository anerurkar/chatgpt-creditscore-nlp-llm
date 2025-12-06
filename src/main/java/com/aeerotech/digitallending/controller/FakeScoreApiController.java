
package com.aeerotech.digitallending.controller;

import com.aeerotech.digitallending.model.CustomerScore;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/internal/scores")
public class FakeScoreApiController {

    private static final Map<String, CustomerScore> DATA = Map.of(
        "CUST1001", new CustomerScore("CUST1001", 720, 11),
        "CUST1002", new CustomerScore("CUST1002", 650, 28),
        "CUST1003", new CustomerScore("CUST1003", 540, 65)
    );

    @GetMapping("/{customerId}")
    public CustomerScore getScore(@PathVariable String customerId) {
        return DATA.get(customerId);
    }
}
