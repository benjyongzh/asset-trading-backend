package com.tradingapp.trading_service.controllers;

import com.tradingapp.trading_service.Services.TradeImplementation;
import com.tradingapp.trading_service.client.OrderClient;
import com.tradingapp.trading_service.dtos.TradeDTO;
import com.tradingapp.trading_service.models.Order;
import com.tradingapp.trading_service.models.Trade;
import com.tradingapp.trading_service.repositories.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradingController.class);

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private TradeImplementation tradeImplementation;

    @Autowired
    private OrderClient orderClient;

    @GetMapping
    public List<Trade> findAllTrades(){
        LOGGER.info("trade findAll");
        return tradeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Trade findById(@PathVariable Long id){
        LOGGER.info("trade findById: {}", id);
        return tradeRepository.findById(id);
    }

//    @GetMapping("/orders")
//    public List<Order> findAllOrders(){
//        LOGGER.info("order findAll");
//        return orderClient.findAll();
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addTrade(@RequestBody TradeDTO tradeDTO){
        LOGGER.info("new trade: {}", tradeDTO);
        return new ResponseEntity<>(tradeImplementation.executeTrade(tradeDTO), HttpStatus.ACCEPTED);
    }
}
