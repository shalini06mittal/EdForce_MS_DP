package com.jpmc.ms.ForexService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.ms.ForexService.model.CurrencyExcchangeResponse;
import com.jpmc.ms.ForexService.model.ExchangeValue;
import com.jpmc.ms.ForexService.repository.ExchangeValueRepository;

@RestController
public class ForexController {


    @Autowired
    private ExchangeValueRepository repository;
    
    @Autowired
	private Environment env;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);

        return exchangeValue;
    }

    
    @GetMapping("/resp/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcchangeResponse retrieveExchangeValuePort
            (@PathVariable String from, @PathVariable String to){

    	String port = env.getProperty("server.port");
    	System.out.println(repository.count());
    	ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);
    	CurrencyExcchangeResponse resp = new CurrencyExcchangeResponse(exchangeValue.getId(), from, to, exchangeValue.getConversionMultiple(), port);
        return resp;
    }
}

