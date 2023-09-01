package com.jpmc.ms.ForexService.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class CurrencyExcchangeResponse {

	
    private Long id;
    private String from;
    private String to;
    
    private BigDecimal conversionMultiple;

    private String port;
    
    public CurrencyExcchangeResponse() {

    }


    public CurrencyExcchangeResponse(Long id, String from, String to, BigDecimal conversionMultiple, String port) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
    }

    
    public String getPort() {
		return port;
	}


	public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }
}
