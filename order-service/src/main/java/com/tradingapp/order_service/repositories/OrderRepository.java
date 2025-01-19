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
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Order> findAll(){
        return orders;
    }

    public String setOrderQuantity(Long id, Integer quantity){
        // Find the object by its unique identifier
        for (int i = 0; i < orders.size(); i++) {
            Order currentOrder = orders.get(i);
            if (currentOrder.getId().equals(id)) {
                // Update the object at this index
                Order updatedOrder = new Order(
                        currentOrder.getId(),
                        currentOrder.getDateTime(),
                        currentOrder.getClientCode(),
                        currentOrder.getOrderType(),
                        currentOrder.getAssetCode(),
                        quantity,
                        currentOrder.getCurrencyCode(),
                        currentOrder.getAmount());
                orders.set(i, updatedOrder);
                return "updated order:"  + updatedOrder.toString();
            }
        }
        return "no orders updated.";
    }

}
