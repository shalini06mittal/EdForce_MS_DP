package com.ms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyExchangeController {

	@Autowired
	private RestTemplate template;
	
	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBeanResponse calculateAmount(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity){
		
		String uri = "http://FOREX-SERVICE/resp/currency-exchange/from/{from}/to/{to}";
		Map<String, String> map = new HashMap<>();
		map.put("from", from);
		map.put("to", to);
		//RestTemplate template = new RestTemplate();
		//ConversionBean bean = template.getForObject(uri, ConversionBean.class, map);
		
		ResponseEntity<ConversionBeanResponse> resp = template.getForEntity(uri, ConversionBeanResponse.class,map);
		ConversionBeanResponse bean = resp.getBody();
		System.out.println(resp.getStatusCode());
		System.out.println(bean.getPort() + " : "+bean.getConversionMultiple());
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
	}	
	
	@Autowired
	private ForexFeignCleint feignCleint;
	
	@RequestMapping("/exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBeanResponse calculateAmountWithFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{	
		ConversionBeanResponse bean = feignCleint.fetchMultipleResponse(from, to);
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
	}	
	
}
