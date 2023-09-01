package com.techgatha.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techgatha.model.UserOrderWrapper;

@Service
public class BookOrderService {

	@Autowired
	BookOrderFeignClient bookOrderFeignClient;

	@HystrixCommand(fallbackMethod = "getBooksOrderedWrapperFallback")
	public UserOrderWrapper getBooksOrderedWrapper(String email)
	{
		UserOrderWrapper ordersWrapper = this.bookOrderFeignClient.getBookOrderDetailsWrapper1(email);
		return ordersWrapper;
	}
	public UserOrderWrapper getBooksOrderedWrapperFallback(String email)
	{
		UserOrderWrapper ordersWrapper = new UserOrderWrapper();
		ordersWrapper.setBookOrders(new ArrayList());
		ordersWrapper.setMemberType("NOT AVAILABLE");
		return ordersWrapper;
	}
}
