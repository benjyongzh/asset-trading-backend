package com.tradingapp.user_service.client;

import com.tradingapp.user_service.models.Asset;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface AssetClient {
    @GetExchange("/asset/bycode/{assetCode}")
    public Asset findByAssetCode(@PathVariable String assetCode);

}
