package com.tradingapp.reporting_service.client;

import com.tradingapp.reporting_service.models.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface OrderClient {
    @GetExchange("/orders/{id}")
    public Order findById(@PathVariable Long id);

    @GetExchange("/orders")
    public List<Order> findAll();
}
