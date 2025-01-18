package com.tradingapp.asset_service.services;

import com.tradingapp.asset_service.models.Asset;
import com.tradingapp.asset_service.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetImplementation {
    @Autowired
    private AssetRepository assetRepository;


    public boolean validateAssetOfOrder(String assetCode, Integer orderQuantity){
        try {
            Asset asset = assetRepository.findAssetByCode(assetCode);
//            boolean isValidAsset = assetRepository.findAssetByCode(assetCode);
            Integer minQuantity = asset.getMinOrderQuantity();
            return orderQuantity >= minQuantity && orderQuantity % minQuantity != 0;
        } catch (Exception e) {
            return false;
        }
    }

}
