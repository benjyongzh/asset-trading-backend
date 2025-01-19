package com.tradingapp.order_service.client;

import com.tradingapp.order_service.models.Asset;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface AssetClient {
    @PostExchange("/assets/validateassetoforder")
    public boolean validateAssetOfOrder(@RequestParam(name="assetcode") String assetCode, @RequestParam(name="orderquantity") Integer orderQuantity);

}
