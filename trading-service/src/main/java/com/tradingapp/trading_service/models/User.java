package com.tradingapp.trading_service.models;

public class User {
    private Long id;
    private String clientCode;

    public User(Long id, String clientCode) {
        this.id = id;
        this.clientCode = clientCode;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", clientCode='" + clientCode + '\'' +
                '}';
    }
}
