package com.tradingapp.order_service.client;

import com.tradingapp.order_service.models.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface OrderMatchingEngineClient {
    @PostExchange("/ordermatchingengine/checkforviabletrades")
    public void checkForViableTrades(@RequestBody Order order);

}
