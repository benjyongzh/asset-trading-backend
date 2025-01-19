package com.tradingapp.order_matching_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMatchingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingEngineApplication.class, args);
	}

}
