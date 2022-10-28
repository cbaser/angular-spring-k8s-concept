package com.cbaser.spring.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("user-api", r -> r.path("/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-micro-api"))
                .route("car-api", r -> r.path("/vehicle/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://car-micro-api"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .build();
    }
}
