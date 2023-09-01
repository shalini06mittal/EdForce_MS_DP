package com.ms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FOREX-SERVICE")
public interface ForexFeignCleint {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ConversionBean fetchMultiple(
			@PathVariable String from, 
			@PathVariable String to);
	
	@GetMapping("/resp/currency-exchange/from/{from}/to/{to}")
	public ConversionBeanResponse fetchMultipleResponse(
			@PathVariable String from, 
			@PathVariable String to);
}
