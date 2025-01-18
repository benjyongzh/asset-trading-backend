package com.tradingapp.order_service.controllers;

import com.tradingapp.order_service.client.AssetClient;
import com.tradingapp.order_service.client.UserClient;
import com.tradingapp.order_service.dtos.OrderDTO;
import com.tradingapp.order_service.models.Order;
import com.tradingapp.order_service.repositories.OrderRepository;
import com.tradingapp.order_service.services.OrderImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderImplementation orderImplementation;

    @Autowired
    private AssetClient assetClient;

    @Autowired
    private UserClient userClient;

    @GetMapping
    public List<Order> findAll(){
        LOGGER.info("order findAll");
        return orderRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> order(@RequestBody OrderDTO orderDTO){
        LOGGER.info("new order: {}", orderDTO);
        Order order = orderImplementation.createOrderObject(orderDTO);
        boolean orderIsValid = orderImplementation.orderIsValid(order);

        if (orderIsValid){
            return new ResponseEntity<>(String.format("Order Added: %s", orderRepository.addOrder(order).toString()),HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Order Declined. Invalid values entered.", HttpStatus.BAD_REQUEST);
        }
    }

}
