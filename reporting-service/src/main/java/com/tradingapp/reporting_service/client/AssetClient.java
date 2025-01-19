package com.tradingapp.reporting_service.client;

import com.tradingapp.reporting_service.models.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface AssetClient {
    @GetExchange("/assets")
    public List<Asset> findAll();

    @GetMapping("/assets/{id}")
    public Asset findById(@PathVariable Long id);
}
