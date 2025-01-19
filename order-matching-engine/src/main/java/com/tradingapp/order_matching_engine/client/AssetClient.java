package com.tradingapp.order_matching_engine.client;

import com.tradingapp.order_matching_engine.models.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface AssetClient {
    @GetExchange("/assets/{id}")
    public Asset findById(@PathVariable Long id);

}
