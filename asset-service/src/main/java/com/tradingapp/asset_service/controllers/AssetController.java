package com.tradingapp.asset_service.controllers;

import com.tradingapp.asset_service.models.Asset;
import com.tradingapp.asset_service.repositories.AssetRepository;

import com.tradingapp.asset_service.services.AssetImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetImplementation assetImplementation;

    @PostMapping("/add")
    public Asset add(@RequestBody Asset asset){
        LOGGER.info("add asset: {}", asset);
        return assetRepository.addAsset(asset);
    }

    @GetMapping
    public List<Asset> findAll(){
        LOGGER.info("asset findAll");
        return assetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Asset findById(@PathVariable Long id){
        LOGGER.info("asset findById: {}", id);
        return assetRepository.findById(id);
    }

    @PostMapping("/validateassetoforder")
    public boolean validateAssetOfOrder(@RequestParam(name="assetcode") String assetCode, @RequestParam(name="orderquantity") Integer orderQuantity){
        LOGGER.info("asset validateassetoforder: " + assetCode + ", orderquantity: " + orderQuantity);
        return assetImplementation.validateAssetOfOrder(assetCode, orderQuantity);
    }

}
