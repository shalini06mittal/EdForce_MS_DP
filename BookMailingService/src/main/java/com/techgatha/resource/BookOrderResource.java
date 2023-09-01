package com.techgatha.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.dto.BookOrderWrapper;
import com.techgatha.model.BookOrder;
import com.techgatha.repository.BookOrderRepository;

@RestController
@RequestMapping("/orders")
public class BookOrderResource {

	@Autowired
	BookOrderRepository repository;
/**
 * BMS => BRS -> rating
 * 
 * private String bookid;
	private String datetime;
	rating value => map<bookid, rating>
 * @param email
 * @return
 */
	
	@GetMapping("/{email}")
	public List<BookOrder> getBooksOrderedByUser(@PathVariable String email)
	{
		return repository.findByEmail(email).stream()
				.map(order -> 
				{
					BookOrder obj = new BookOrder();
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					return obj;
		}).collect(Collectors.toList());
	}
	@GetMapping("/wrapper/{email}")
	public BookOrderWrapper getBooksOrderedByUserWrapper(@PathVariable String email)
	{
		System.out.println("email BMS "+email);
		List<BookOrder> orders = new ArrayList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		orders = repository.findByEmail(email).stream()
				.map(order -> 
				{
					BookOrder obj = new BookOrder();
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					// BRS
					map.put(order.getBookid(), 3);
					return obj;
		}).collect(Collectors.toList());
		System.out.println(orders);
		BookOrderWrapper wrapper = new BookOrderWrapper();
		wrapper.setOrders(orders);
		
		wrapper.setMap(map);
		return wrapper;
	}
	
}
