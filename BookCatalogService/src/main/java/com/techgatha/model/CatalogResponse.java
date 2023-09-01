package com.techgatha.model;

import java.util.List;
import java.util.Map;

public class CatalogResponse {

	private String email;
	List<UserCatalog> catalog;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<UserCatalog> getCatalog() {
		return catalog;
	}
	public void setCatalog(List<UserCatalog> catalog) {
		this.catalog = catalog;
	}
	
}
