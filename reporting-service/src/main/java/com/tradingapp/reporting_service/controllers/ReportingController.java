package com.tradingapp.reporting_service.controllers;

import com.tradingapp.reporting_service.client.AssetClient;
import com.tradingapp.reporting_service.client.OrderClient;
import com.tradingapp.reporting_service.client.TradeClient;
import com.tradingapp.reporting_service.models.Asset;
import com.tradingapp.reporting_service.models.Order;
import com.tradingapp.reporting_service.models.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportingController.class);
    @Autowired
    AssetClient assetClient;
    @Autowired
    OrderClient orderClient;
    @Autowired
    TradeClient tradeClient;

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderClient.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderClient.findById(id);
    }

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetClient.findAll();
    }

    @GetMapping("/assets/{id}")
    public Asset getAssetById(@PathVariable Long id){
        return assetClient.findById(id);
    }

    @GetMapping("/trades")
    public List<Trade> getTrades(){
        return tradeClient.findAll();
    }

//    @GetMapping("/trades/filter")
//    public List<Trade> getFitleredTrades(@RequestParam(name="assetid",required = false) Long assetId,
//                                         @RequestParam(name="currency", required = false) String currencyName){
//        return tradeClient.filterAll(assetId, currencyName);
//    }

    @GetMapping("/trades/{id}")
    public Trade getTradeById(@PathVariable Long id){
        return tradeClient.findById(id);
    }
}
