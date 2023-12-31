package com.techgatha.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.Book;
import com.techgatha.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookResource {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/{bookid}")
	public Book getBook(@RequestHeader("book-req-header") String header,
			@PathVariable String bookid)
	{
		//return repository.findById(bookid).get();
		Book b1 = repository.findById(bookid).get();
		b1.setHeader(header);
		return b1;
	}
}
