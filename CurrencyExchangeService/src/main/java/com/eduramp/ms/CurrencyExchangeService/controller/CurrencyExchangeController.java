package com.eduramp.ms.CurrencyExchangeService.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eduramp.ms.CurrencyExchangeService.model.ConversionBean;

@RestController
public class CurrencyExchangeController {

	/**
	 * 1) many methods and controllers with different mapping
	 * 2) all mapping needs access to Resttemplate object to make RESt API calls
	 * 3) The services since its dynamicn will be deployed on a dynamic addres
	 * 4) localhost:8000 -> no more be static
	 * 
	 * 1) RestTamplate object needs to be created everytime -> externalize this : 
	 * Autowrire template : @Bean
	 * 2) location is dynamic : cannot write localhost:8000/
	 * 3) need a way to locate them still -> needs to have a specific id : constant
	 * 4) smeone who can make these services available >: monitor: discoverable 
	 * 5) someone : eureka server : 
	 * 	making services discoverbale, monitoring, checking the status , health, doing the load balancing
	 * 5) services needs to register themselves to be discoverable with a unique id
	 */
	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean calculateAmount(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		
		String uri = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
		Map<String, String> map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		RestTemplate template = new RestTemplate();
		//ConversionBean bean = template.getForObject(uri, ConversionBean.class, map);
		
		ResponseEntity<ConversionBean> resp = template.getForEntity(uri, ConversionBean.class,map);
		ConversionBean bean = resp.getBody();
		System.out.println(resp.getStatusCode());
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
	}	
}
