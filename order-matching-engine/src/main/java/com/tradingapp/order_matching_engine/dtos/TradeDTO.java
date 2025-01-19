package com.tradingapp.order_matching_engine.dtos;

public class TradeDTO {
    private Long id;

    private Long buyOrderId;

    private Long sellOrderId;

    private Integer quantity;

    public TradeDTO() {
    }

    public TradeDTO(Long buyOrderId, Long sellOrderId, Integer quantity) {
        this.id = 0L;
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
}
