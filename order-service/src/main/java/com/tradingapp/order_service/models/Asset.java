package com.tradingapp.order_service.models;


import java.util.ArrayList;
import java.util.List;

public class Asset {
    private Long id;
    private String assetCode;
    private String assetName;
    private List<Currency> currencies = new ArrayList<>();

    private Integer minOrderQuantity;

    public Asset(Long id, String assetCode, String assetName, List<Currency> currencies, Integer minOrderQuantity) {
        this.id = id;
        this.assetCode = assetCode;
        this.assetName = assetName;
        this.currencies = currencies;
        this.minOrderQuantity = minOrderQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public Integer getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Integer minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", assetCode='" + assetCode + '\'' +
                ", assetName='" + assetName + '\'' +
                ", currencies=" + currencies +
                '}';
    }
}
