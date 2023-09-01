package com.citi.ms;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class ConsumeRestController {

	@Autowired
	private MyService service;
	
	@GetMapping("/greeting/{username}")
	public CompletableFuture<String> messsgaeFromProducer(@PathVariable String username)
	{
		return service.getMessage(username);
	}
}
