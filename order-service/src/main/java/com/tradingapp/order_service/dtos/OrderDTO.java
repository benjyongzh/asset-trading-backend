package com.tradingapp.order_service.dtos;

import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;

    private String clientCode;

    private String orderType; //buy/sell

    private String assetCode;

    private Integer quantity;

    private String currencyCode;

    public OrderDTO(Long id, String clientCode, String orderType, String assetCode, Integer quantity, String currencyCode) {
        this.id = id;
        this.clientCode = clientCode;
        this.orderType = orderType;
        this.assetCode = assetCode;
        this.quantity = quantity;
        this.currencyCode = currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
