package com.tradingapp.order_matching_engine.models;

import java.time.LocalDateTime;

public class Trade {
    private Long id;

    private LocalDateTime dateTime;

    private Long buyOrderId;

    private Long sellOrderId;

    private Integer quantity;


    public Trade(Long id, Long buyOrderId, Long sellOrderId, Integer quantity) {
        this.id = id;
        this.dateTime = LocalDateTime.now();
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.quantity = quantity;
    }

    public Trade(Long id, LocalDateTime dateTime, Long buyOrderId, Long sellOrderId, Integer quantity) {
        this.id = id;
        this.dateTime = dateTime;
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.quantity = quantity;
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

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", buyOrderId=" + buyOrderId +
                ", sellOrderId=" + sellOrderId +
                ", quantity=" + quantity +
                '}';
    }
}
