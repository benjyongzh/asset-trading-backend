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
import java.util.stream.Collectors;

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
    public List<Trade> findAll(){
        LOGGER.info("trade findAll");
        return tradeRepository.findAll();
    }

//    @GetMapping("/filter")
//    public List<Trade> filterAll(@RequestParam(name="assetid",required = false) Long assetId,
//                                 @RequestParam(name="currency", required = false) String currencyName){
//        return tradeRepository.findAll().stream()
//                .filter(item -> (assetId == null || assetId.equals(getAssetId(item))))
//                .filter(item -> (currencyName == null || currencyName.equals(getCurrency(item))))
//                .collect(Collectors.toList());
//    };
//
//    public Long getAssetId(Trade trade){
//
//    }
//
//    public String getCurrency(Trade trade){
//
//    }


    @GetMapping("/{id}")
    public Trade findById(@PathVariable Long id){
        LOGGER.info("trade findById: {}", id);
        return tradeRepository.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTrade(@RequestBody TradeDTO tradeDTO){
        LOGGER.info("new trade: {}", tradeDTO);
        try {
            Trade tradeExecuted = tradeImplementation.executeTrade(tradeDTO);
            return new ResponseEntity<>("Trade executed successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Trade could not be created. Server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
