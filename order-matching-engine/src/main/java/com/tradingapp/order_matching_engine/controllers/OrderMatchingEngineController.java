package com.tradingapp.order_matching_engine.controllers;

import com.tradingapp.order_matching_engine.client.AssetClient;
import com.tradingapp.order_matching_engine.client.OrderClient;
import com.tradingapp.order_matching_engine.client.TradeClient;
import com.tradingapp.order_matching_engine.models.Order;
import com.tradingapp.order_matching_engine.services.OrderMatchingEngineImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordermatchingengine")
public class OrderMatchingEngineController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMatchingEngineController.class);

    @Autowired
    private OrderMatchingEngineImplementation orderMatchingEngineImplementation;

    @Autowired
    private AssetClient assetClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private TradeClient tradeClient;

    @PostMapping("/checkforviabletrades")
    public void checkForViableTrades(@RequestBody Order order){
        LOGGER.info("checkForViableTrades for order: {}", order);
        orderMatchingEngineImplementation.checkForViableTrades(order);
    }
}
