package com.tradingapp.order_service.client;

import com.tradingapp.order_service.models.Asset;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface AssetClient {
    @PostExchange("/asset/validateassetoforder/{assetCode}")
    public boolean validateAssetOfOrder(@PathVariable String assetCode, Integer orderQuantity);

}
