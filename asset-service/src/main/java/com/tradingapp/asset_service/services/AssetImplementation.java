package com.tradingapp.asset_service.services;

import com.tradingapp.asset_service.models.Asset;
import com.tradingapp.asset_service.repositories.AssetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetImplementation {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssetImplementation.class);
    @Autowired
    private AssetRepository assetRepository;


    public boolean validateAssetOfOrder(String assetCode, Integer orderQuantity){
        try {
            Asset asset = assetRepository.findAssetByCode(assetCode);
//            boolean isValidAsset = assetRepository.findAssetByCode(assetCode);
            Integer minQuantity = asset.getMinOrderQuantity();
            LOGGER.info("asset: " + asset + ", minQuantity: " + minQuantity +  ", orderQuantity: " + orderQuantity);
            return orderQuantity >= minQuantity && orderQuantity % minQuantity == 0;
        } catch (Exception e) {
            LOGGER.error("exception: " + e);
            return false;
        }
    }

}
