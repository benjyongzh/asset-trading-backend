package com.tradingapp.order_service.models;

import java.time.LocalDateTime;

public class Order {
    private Long id;

    private LocalDateTime dateTime;
    private String clientCode;

    private String orderType; //buy/sell

    private String assetCode;

    private Integer quantity;

    private String currencyCode;

    private float amount;

    public Order() {
    }

    public Order(Long id, String clientCode, String orderType, String assetCode, Integer quantity, String currencyCode) {
        this.id = id;
        this.dateTime = LocalDateTime.now();
        this.clientCode = clientCode;
        this.orderType = orderType;
        this.assetCode = assetCode;
        this.quantity = quantity;
        this.currencyCode = currencyCode;
        this.amount = 0;
    }

    public Order(Long id, LocalDateTime dateTime, String clientCode, String orderType, String assetCode, Integer quantity, String currencyCode, float amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.clientCode = clientCode;
        this.orderType = orderType;
        this.assetCode = assetCode;
        this.quantity = quantity;
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", clientCode='" + clientCode + '\'' +
                ", orderType='" + orderType + '\'' +
                ", assetCode='" + assetCode + '\'' +
                ", quantity=" + quantity +
                ", currencyCode='" + currencyCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}

