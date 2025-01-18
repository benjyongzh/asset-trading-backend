package com.tradingapp.asset_service.repository;

import com.tradingapp.asset_service.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AssetRepository extends JpaRepository<Asset, Long> {
//    private List<Asset> assets = new ArrayList<>();
//
//    public Asset addAsset(Asset asset){
//        assets.add(asset);
//        return asset;
//    }
}
