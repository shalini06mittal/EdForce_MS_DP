package com.jpmc.ms.ForexService.repository;

import com.jpmc.ms.ForexService.model.ExchangeValue;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
