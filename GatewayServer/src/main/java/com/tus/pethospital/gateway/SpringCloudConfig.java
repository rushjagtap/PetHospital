package com.tus.pethospital.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("Vets Module", rt -> rt.path("/api/v1/vets/**")
                        .uri("http://localhost:8081/"))
                .route("Owner Module", rt -> rt.path("/api/v1/owners/**")
                        .uri("http://localhost:8082/"))
                .route("Pet Module", rt -> rt.path("/api/v1/pets/**")
                        .uri("http://localhost:8082/"))
                .build();

    }

}
