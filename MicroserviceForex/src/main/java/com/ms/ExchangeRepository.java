package com.ms;

import org.springframework.data.repository.CrudRepository;



public interface ExchangeRepository extends CrudRepository<CurrencyExcchange, Long>{

	public CurrencyExcchange findByFromAndTo(String from,String to);
}
