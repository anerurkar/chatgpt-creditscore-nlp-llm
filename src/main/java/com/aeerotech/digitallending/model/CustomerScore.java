package com.aeerotech.digitallending.model;

public class CustomerScore {
    private String customerId;
    private int creditScore;
    private int fraudScore;

    public CustomerScore() {}

    public CustomerScore(String customerId, int creditScore, int fraudScore) {
        this.customerId = customerId;
        this.creditScore = creditScore;
        this.fraudScore = fraudScore;
    }

    public String getCustomerId() { return customerId; }
    public int getCreditScore() { return creditScore; }
    public int getFraudScore() { return fraudScore; }
}
