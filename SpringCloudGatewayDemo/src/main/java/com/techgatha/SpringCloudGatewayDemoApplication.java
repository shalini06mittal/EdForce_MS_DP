package com.techgatha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//https://medium.com/@xuezhongyu01/predict-of-spring-cloud-gateway-907bd05eb86d

//https://www.baeldung.com/spring-security-oauth-resource-server
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayDemoApplication.class, args);
	}
	
//	 @Bean
//	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//	        return builder.routes()
//	                .route(r -> r.path("/employee/**")
//	                        .uri("http://localhost:8081/")
//	                        .id("employeeModule"))
//
//	                .route(r -> r.path("/consumer/**")
//	                        .uri("http://localhost:8082/")
//	                        .id("consumerModule"))
//	                .build();
//	    }

}
