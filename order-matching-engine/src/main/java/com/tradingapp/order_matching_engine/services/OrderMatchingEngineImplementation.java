package com.tradingapp.order_matching_engine.services;

import com.netflix.discovery.converters.Auto;
import com.tradingapp.order_matching_engine.client.AssetClient;
import com.tradingapp.order_matching_engine.client.OrderClient;
import com.tradingapp.order_matching_engine.client.TradeClient;
import com.tradingapp.order_matching_engine.controllers.OrderMatchingEngineController;
import com.tradingapp.order_matching_engine.dtos.TradeDTO;
import com.tradingapp.order_matching_engine.models.Order;
import com.tradingapp.order_matching_engine.models.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderMatchingEngineImplementation {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMatchingEngineImplementation.class);

    @Autowired
    private AssetClient assetClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private TradeClient tradeClient;

    public void checkForViableTrades(Order order) {
        if (order.getQuantity() <= 0) return;

        LOGGER.info("checking for viable trades for order id: " + order.getId());
        List<Order> allPossibleOrders = orderClient.findAll()
                .stream()
                .filter(currentOrder ->
                        currentOrder.getCurrencyCode().equals(order.getCurrencyCode()))
                .filter(currentOrder ->
                        isOppositeOrderType(currentOrder, order))
                .filter(currentOrder ->
                        currentOrder.getQuantity() > 0)
                .toList();

        if (!allPossibleOrders.isEmpty()) {
            executeTradesForOrder(order, allPossibleOrders);
        }
    }

    public boolean isOppositeOrderType(Order order1, Order order2){
        return !order1.getOrderType().equals(order2.getOrderType());
    }

    public void executeTradesForOrder(Order order, List<Order> orderList) {
        LOGGER.info("executing trade for order id: " + order.getId());
        Order nextOrder = orderList.get(0);
        TradeDTO newTrade = new TradeDTO();
        if (nextOrder.getQuantity() > order.getQuantity()){
            newTrade.setQuantity(order.getQuantity());
        } else {
            newTrade.setQuantity(nextOrder.getQuantity());
        }
        if (order.getOrderType().equals("buy")){
            newTrade.setBuyOrderId(order.getId());
            newTrade.setSellOrderId(nextOrder.getId());
        } else {
            newTrade.setBuyOrderId(nextOrder.getId());
            newTrade.setSellOrderId(order.getId());
        }

        String tradeId = tradeClient.addTrade(newTrade);
//        Trade trade = tradeClient.findById(Long.valueOf(tradeId));
        Order updatedOrder = orderClient.findById(order.getId());


        //recursive
        checkForViableTrades(updatedOrder);
    }


}
