package com.techgatha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private String bookid;
	private String title;
	private String description;
	private double price;
	
	private String header;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Book(String bookid, String title, String description, double price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.description = description;
		this.price = price;
	}


	public String getHeader() {
		return header;
	}



	public void setHeader(String header) {
		this.header = header;
	}
	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", description=" + description + ", price=" + price
				+ "]";
	}
	
}
