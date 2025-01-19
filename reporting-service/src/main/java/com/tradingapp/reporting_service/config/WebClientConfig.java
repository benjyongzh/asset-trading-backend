package com.tradingapp.reporting_service.config;

import com.tradingapp.reporting_service.client.AssetClient;
import com.tradingapp.reporting_service.client.OrderClient;
import com.tradingapp.reporting_service.client.TradeClient;
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
    public WebClient orderWebClient(){
        return WebClient.builder().baseUrl("http://order-service").filter(filterFunction).build();
    }

    @Bean
    public OrderClient orderClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(orderWebClient())).build();
        return httpServiceProxyFactory.createClient(OrderClient.class);
    }


    @Bean
    public WebClient assetWebClient(){
        return WebClient.builder().baseUrl("http://asset-service").filter(filterFunction).build();
    }

    @Bean
    public AssetClient assetClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(assetWebClient())).build();
        return httpServiceProxyFactory.createClient(AssetClient.class);
    }

    @Bean
    public WebClient tradeWebClient(){
        return WebClient.builder().baseUrl("http://trading-service").filter(filterFunction).build();
    }

    @Bean
    public TradeClient tradeClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(tradeWebClient())).build();
        return httpServiceProxyFactory.createClient(TradeClient.class);
    }
}
