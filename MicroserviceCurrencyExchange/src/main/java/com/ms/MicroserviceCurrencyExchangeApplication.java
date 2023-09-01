package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceCurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCurrencyExchangeApplication.class, args);
	}
	// template.get
	@Bean
	@LoadBalanced
	public RestTemplate template()
	{
		return new RestTemplate();
	}

}
