package com.tradingapp.asset_service.repositories;

import com.tradingapp.asset_service.models.Asset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AssetRepository {
    private List<Asset> assets = new ArrayList<>();

    public Asset addAsset(Asset asset){
        assets.add(asset);
        return asset;
    }

    public Asset findById(Long id){
        return assets.stream().filter(asset -> asset.getId().equals(id)).findFirst().orElseThrow();
    }

    public Asset findAssetByCode(String assetCode){
        return assets.stream().filter(asset -> asset.getAssetCode().equals(assetCode)).findFirst().orElseThrow();
    }

    public List<Asset> findAll(){
        return assets;
    }
}
