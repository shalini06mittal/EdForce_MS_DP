package com.techgatha.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;
import com.techgatha.model.UserOrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

	@Autowired
	BookFeignClient bookFeignClient;

	@HystrixCommand(fallbackMethod = "getBooksWrapperFallback")
	public UserCatalog getBooksWrapper(String bookid)  {

		if(bookid.equals("B3"))
			throw new RuntimeException("Book not found");
		UserCatalog catalog = this.bookFeignClient.getBookDetails(bookid);
		return catalog;
	}

	public UserCatalog getBooksWrapperFallback(String email)
	{
	
		
		UserCatalog catalog = new UserCatalog(email,"","",0.0,"");
		return catalog;
	}
}
