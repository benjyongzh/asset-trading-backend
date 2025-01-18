package com.tradingapp.order_service.services;

import com.tradingapp.order_service.client.AssetClient;
import com.tradingapp.order_service.client.UserClient;
import com.tradingapp.order_service.dtos.OrderDTO;
import com.tradingapp.order_service.models.Order;
import com.tradingapp.order_service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderImplementation {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AssetClient assetClient;

    @Autowired
    private UserClient userClient;
    public Order createOrderObject(OrderDTO orderDTO){
        Order order = new Order(orderDTO.getId(),
                orderDTO.getClientCode(),
                orderDTO.getOrderType(),
                orderDTO.getAssetCode(),
                orderDTO.getQuantity(),
                orderDTO.getCurrencyCode());

        order.setDateTime(LocalDateTime.now()); // Set current date-time
//        TODO what is amount suppose to be?
        order.setAmount(orderDTO.getQuantity());
        return order;
    }

    public boolean orderIsValid(Order order){
//        talk to assetcontroller to validate order's assetcode
        boolean assetIsValid = assetClient.validateAssetOfOrder(order.getAssetCode(), order.getQuantity());

//        talk to userController to validate user's clientcode
        boolean userIsValid = userClient.validateUserByCode(order.getClientCode());

        return assetIsValid && userIsValid;
    }
}
