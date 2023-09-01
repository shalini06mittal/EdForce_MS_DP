package com.techgatha.dto;

import java.util.List;
import java.util.Map;

import com.techgatha.model.BookOrder;

public class BookOrderWrapper {

	List<BookOrder> orders;
	Map<String, Integer> map;
	
	public List<BookOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<BookOrder> orders) {
		this.orders = orders;
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
}
