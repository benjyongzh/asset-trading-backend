package com.tradingapp.order_service.config;

import com.tradingapp.order_service.client.AssetClient;
import com.tradingapp.order_service.client.OrderMatchingEngineClient;
import com.tradingapp.order_service.client.UserClient;
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

    @Bean
    public WebClient userWebClient(){
        return WebClient.builder().baseUrl("http://user-service").filter(filterFunction).build();
    }

    @Bean
    public UserClient userClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(userWebClient())).build();
        return httpServiceProxyFactory.createClient(UserClient.class);
    }


    @Bean
    public WebClient orderMatchingEngineWebClient(){
        return WebClient.builder().baseUrl("http://order-matching-engine").filter(filterFunction).build();
    }

    @Bean
    public OrderMatchingEngineClient orderMatchingEngineClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(orderMatchingEngineWebClient())).build();
        return httpServiceProxyFactory.createClient(OrderMatchingEngineClient.class);
    }
}
