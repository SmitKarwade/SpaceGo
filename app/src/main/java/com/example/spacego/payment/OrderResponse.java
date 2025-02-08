package com.example.spacego.payment;

public class OrderResponse {
    private String orderId;
    private String currency;
    private String amount;

    public OrderResponse(String orderId, String currency, String amount) {
        this.orderId = orderId;
        this.currency = currency;
        this.amount = amount;
    }

    public OrderResponse() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAmount() {
        return amount;
    }
}