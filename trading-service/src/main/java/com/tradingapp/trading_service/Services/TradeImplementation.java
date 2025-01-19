package com.tradingapp.trading_service.Services;

import com.tradingapp.trading_service.client.OrderClient;
import com.tradingapp.trading_service.dtos.TradeDTO;
import com.tradingapp.trading_service.models.Order;
import com.tradingapp.trading_service.models.Trade;
import com.tradingapp.trading_service.repositories.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TradeImplementation {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeImplementation.class);

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private OrderClient orderClient;

    public Trade createTradeObject(TradeDTO tradeDTO){
        Trade trade = new Trade(tradeDTO.getId(),
                tradeDTO.getBuyOrderId(),
                tradeDTO.getSellOrderId(),
                tradeDTO.getQuantity());

        trade.setId(tradeRepository.nextId());
        trade.setDateTime(LocalDateTime.now()); // Set current date-time
        return trade;
    }

    public String executeTrade(TradeDTO tradeDTO){
        Trade trade = createTradeObject(tradeDTO);
        Integer quantity = trade.getQuantity();
        LOGGER.info("trade quantity: {}", quantity);
        Order buyOrder = orderClient.findById(trade.getBuyOrderId());
        LOGGER.info("buy order: {}", buyOrder);
        Order sellOrder = orderClient.findById(trade.getSellOrderId());
        LOGGER.info("sell order: {}", sellOrder);
        Integer newQuantityForBuy = buyOrder.getQuantity() - quantity;
        Integer newQuantityForSell = sellOrder.getQuantity() - quantity;
        orderClient.setOrderQuantity(buyOrder.getId(), newQuantityForBuy);
        orderClient.setOrderQuantity(sellOrder.getId(), newQuantityForSell);
        tradeRepository.addTrade(trade);
        LOGGER.info("trade executed: {}", trade);
        return trade.getId().toString();
    }

}
