package com.tradingapp.order_service.services;

import com.tradingapp.order_service.client.AssetClient;
import com.tradingapp.order_service.client.OrderMatchingEngineClient;
import com.tradingapp.order_service.client.UserClient;
import com.tradingapp.order_service.dtos.OrderDTO;
import com.tradingapp.order_service.models.Order;
import com.tradingapp.order_service.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableAsync
public class OrderImplementation {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderImplementation.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AssetClient assetClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderMatchingEngineClient orderMatchingEngineClient;

    public Order createOrderObject(OrderDTO orderDTO){
        Order order = new Order(orderDTO.getId(),
                orderDTO.getClientCode(),
                orderDTO.getOrderType(),
                orderDTO.getAssetCode(),
                orderDTO.getQuantity(),
                orderDTO.getCurrencyCode());

        order.setDateTime(LocalDateTime.now()); // Set current date-time
//        TODO what is "amount" suppose to be?
        order.setAmount(orderDTO.getQuantity());
        return order;
    }

    public boolean orderIsValid(Order order){
        boolean orderTypeIsValid = order.getOrderType().equals("buy") || order.getOrderType().equals("sell");
//        LOGGER.info("orderTypeIsValid: {}", orderTypeIsValid);

        boolean assetIsValid = assetClient.validateAssetOfOrder(order.getAssetCode(), order.getQuantity());
//        LOGGER.info("assetIsValid: {}", assetIsValid);

        boolean userIsValid = userClient.validateUserByCode(order.getClientCode());
//        LOGGER.info("userIsValid: {}", userIsValid);

        return orderTypeIsValid && assetIsValid && userIsValid;
    }

    @Async("asyncViableTradesChecker")
    public void checkForViableTrades(Order order){
//            call engine to check for possible trades. should thread this out
        LOGGER.info("getting order-matching-engine to check for possible trades for order id: {}", order.getId());
        orderMatchingEngineClient.checkForViableTrades(order);
    }
}
