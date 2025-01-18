package com.tradingapp.user_service.config;

import com.tradingapp.user_service.client.AssetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Bean
    public WebClient assetWebClient(){
        return WebClient.builder().baseUrl("http://asset-service").filter(filterFunction).build();
    }

    @Bean
    public AssetClient assetClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(assetWebClient())).build();
        return httpServiceProxyFactory.createClient(AssetClient.class);
    }
}
