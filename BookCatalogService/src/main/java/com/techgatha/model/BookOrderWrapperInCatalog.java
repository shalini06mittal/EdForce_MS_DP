package com.techgatha.model;

import java.util.List;
import java.util.Map;

public class BookOrderWrapperInCatalog {

	
	List<OrderWrapper> orders;
	
	Map<String, Integer> map;

	public List<OrderWrapper> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderWrapper> orders) {
		this.orders = orders;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
}
