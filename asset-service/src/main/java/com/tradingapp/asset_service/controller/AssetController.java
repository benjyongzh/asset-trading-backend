package com.tradingapp.asset_service.controller;

import com.tradingapp.asset_service.model.Asset;
import com.tradingapp.asset_service.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    AssetRepository assetRepository;
    @PostMapping("/add")
    public void addAsset(@RequestBody Asset asset){
        assetRepository.save(asset);
    }
}
