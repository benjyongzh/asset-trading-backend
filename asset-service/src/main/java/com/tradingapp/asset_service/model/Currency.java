package com.tradingapp.asset_service.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public record Currency(@Id Long id, String currencyCode, String currencyName) {}
