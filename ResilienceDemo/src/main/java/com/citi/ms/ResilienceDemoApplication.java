package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResilienceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilienceDemoApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}
}
