package com.techgatha.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techgatha.model.BookOrderWrapperInCatalog;
import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserOrderWrapper;

@FeignClient(name="BOOK-ORDER-SERVICE")
public interface BookOrderFeignClient {

	
	@GetMapping("/orders/{email}")
	public List<OrderWrapper> getBookOrderDetails( @PathVariable String email);
	
	@RequestMapping("/orders/wrapper/{email}")
	public BookOrderWrapperInCatalog getBookOrderDetailsWrapper( @PathVariable String email);
	
	@RequestMapping("/orders/wrapper/{email}")
	public UserOrderWrapper getBookOrderDetailsWrapper1(@PathVariable String email);
}
	
	

