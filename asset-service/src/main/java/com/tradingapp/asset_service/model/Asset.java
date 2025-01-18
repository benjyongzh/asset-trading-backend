package com.tradingapp.asset_service.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class Asset {
    @Id
    private Long id;
    private String productCode;
    private String productName;
    private List<Currency> currencies = new ArrayList<>();
    private int minOrderQuantity;

    public Asset(Long id, String productCode, String productName, List<Currency> currencies, int minOrderQuantity) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.currencies = currencies;
        this.minOrderQuantity = minOrderQuantity;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", currencies=" + currencies +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public int getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(int minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }
}
