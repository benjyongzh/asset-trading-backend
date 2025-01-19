package com.tradingapp.order_service.client;

import com.tradingapp.order_service.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface UserClient {
    @PostExchange("/users/validateuserbycode")
    public boolean validateUserByCode(@RequestParam(name="usercode") String userCode);

}
