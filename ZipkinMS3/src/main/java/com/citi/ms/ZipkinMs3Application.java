package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZipkinMs3Application {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinMs3Application.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate template()
	{
		return new RestTemplate();
	}
}
