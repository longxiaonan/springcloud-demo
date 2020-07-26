package com.javasea.gateway.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayProviderApplication8003 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayProviderApplication8003.class, args);
    }

}
