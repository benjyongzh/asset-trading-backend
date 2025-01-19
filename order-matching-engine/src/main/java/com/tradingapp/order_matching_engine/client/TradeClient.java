package com.tradingapp.order_matching_engine.client;

import com.tradingapp.order_matching_engine.dtos.TradeDTO;
import com.tradingapp.order_matching_engine.models.Trade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface TradeClient {
    @GetExchange("/trades/{id}")
    public Trade findById(@PathVariable Long id);

        @PostExchange("/trades/add")
    public String addTrade(@RequestBody TradeDTO tradeDTO);

}
