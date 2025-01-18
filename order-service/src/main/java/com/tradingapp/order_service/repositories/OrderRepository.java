package com.tradingapp.order_service.repositories;

import com.tradingapp.order_service.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public Order addOrder(Order order){
        orders.add(order);
        return order;
    }

    public Order findById(Long id){
        return orders.stream().filter(orders -> orders.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Order> findAll(){
        return orders;
    }
}
