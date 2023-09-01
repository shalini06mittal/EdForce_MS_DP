package com.techgatha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techgatha.model.BookOrderWrapperInCatalog;
import com.techgatha.model.CatalogResponse;
import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;

@Service
public class BookCatalogService {

	@Autowired
	BookOrderFeignClient bookOrderFeignClient;
	
	@Autowired
	BookFeignClient bookFeignClient;
	
	
	public List<UserCatalog> getBooksOrdered(String email)
	{	
		List<OrderWrapper> orders = this.bookOrderFeignClient.getBookOrderDetails(email);
		
		return orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalog catalog = this.bookFeignClient.getBookDetails(wrapper.getBookid());
			catalog.setEmail(email);
			catalog.setDatetime(wrapper.getDatetime());
			return catalog;
		}).collect(Collectors.toList());
	}
	public CatalogResponse getBooksOrderedWrapper(String email)
	{	
		BookOrderWrapperInCatalog resp = this.bookOrderFeignClient.getBookOrderDetailsWrapper(email);
		List<OrderWrapper> orders = resp.getOrders();
		Map<String, Integer> map = resp.getMap();
		List<UserCatalog> catalogs = new ArrayList<>();
		catalogs=
		 orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalog catalog = this.bookFeignClient.getBookDetails(wrapper.getBookid());
			catalog.setDatetime(wrapper.getDatetime());
			catalog.setRating(map.get(wrapper.getBookid()));
			return catalog;
		}).collect(Collectors.toList());
		CatalogResponse response = new CatalogResponse();
		response.setCatalog(catalogs);
		response.setEmail(email);
		return response;
	}
	
}
