package com.tradingapp.reporting_service.client;

import com.tradingapp.reporting_service.models.Trade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface TradeClient {
    @GetExchange("/trades")
    public List<Trade> findAll();

//    @GetExchange("/trades/filter/")
//    public List<Trade> filterAll(@RequestParam(name="assetid",required = false) Long assetId,
//                                 @RequestParam(name="currency", required = false) String currencyName);

    @GetMapping("/trades/{id}")
    public Trade findById(@PathVariable Long id);
}
