package com.techgatha.resource;

import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;
import com.techgatha.model.UserOrderWrapper;
import com.techgatha.service.BookCatalogService;
import com.techgatha.service.BookOrderService;
import com.techgatha.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResourceUsingService {

	@Autowired
	private BookOrderService bookOrderService;
	@Autowired
	private BookService bookService;

	@GetMapping("/cb/wrapper/{email}")
	public List<UserCatalog> getBooksPurchasedWrapper(@PathVariable String email)
	{
		UserOrderWrapper ordersWrapper = this.bookOrderService.getBooksOrderedWrapper(email);
		System.out.println(ordersWrapper);
		List<OrderWrapper> orders = ordersWrapper.getBookOrders();
		String memberType = ordersWrapper.getMemberType();
		return orders.stream()
				.map(wrapper ->{
					String bookid= wrapper.getBookid();
					String datetime = wrapper.getDatetime();
					System.out.println(bookid);
					System.out.println(datetime);
					UserCatalog catalog = this.bookService.getBooksWrapper(bookid);
					System.out.println("********");
					catalog.setEmail(email);
					catalog.setDatetime(datetime);
					//catalog.setMemberType(memberType);
					return catalog;
				}).collect(Collectors.toList());
	}
	
}
