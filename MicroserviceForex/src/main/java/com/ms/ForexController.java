package com.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ForexController {

	@Autowired
	ExchangeRepository repository;

	@Autowired
	private Environment env;
	
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcchange retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

    	System.out.println(env.getProperty("server.port"));
    	System.out.println(repository.count());
    	CurrencyExcchange exchangeValue =
                repository.findByFromAndTo(from, to);

        return exchangeValue;
    }
    
    @GetMapping("/resp/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcchangeResponse retrieveExchangeValuePort
            (@PathVariable String from, @PathVariable String to){

    	String port = env.getProperty("server.port");
    	System.out.println(repository.count());
    	CurrencyExcchange exchangeValue =
                repository.findByFromAndTo(from, to);
    	CurrencyExcchangeResponse resp = new CurrencyExcchangeResponse(exchangeValue.getId(), from, to, exchangeValue.getConversionMultiple(), port);
        return resp;
    }

}

