package com.citi.ms;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class MyService {

	@Autowired
	private RestTemplate template;
	
	// Resilience 4j properties
//	@CircuitBreaker(fallbackMethod = "getMessageFallback", name = "producer")
//	public String getMessage(String username)
//	{
//		return template.getForObject("http://REST-PRODUCER/greet/{username}", String.class, username);
//	}
//	
//	public String getMessageFallback(String username, RuntimeException e)
//	{
//		return "Hey Guest";
//	}
	
	// Resilience 4j properties + timer
	@TimeLimiter(name="producer",fallbackMethod = "getMessageFallback")
	//@CircuitBreaker(fallbackMethod = "getMessageFallback", name = "producer")
	//@Retry(name = "producer")
	public CompletableFuture<String> getMessage(String username)
	{
		System.out.println("getting message");
		String message = template.getForObject("http://REST-PRODUCER/greet/{username}", String.class, username);
		return CompletableFuture.supplyAsync(()->message);
	}
	
	public CompletableFuture<String> getMessageFallback(String username, RuntimeException e)
	{
		return CompletableFuture.supplyAsync(()->"Hey GUEST");
	}
}
