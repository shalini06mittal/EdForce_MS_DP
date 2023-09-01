package com.ms;

import java.math.BigDecimal;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class MicroserviceForexApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		
		SpringApplication.run(MicroserviceForexApplication.class, args);
		String port = context.getEnvironment().getProperty("server.port");
		System.out.println(port);
	}
	
	@Autowired
	private ExchangeRepository repo;
	
	@Bean
	public void add()
	{
		repo.save(new CurrencyExcchange(1001L, "USD", "INR", new BigDecimal(80.0)));
		repo.save(new CurrencyExcchange(1002L, "USD", "EUR", new BigDecimal(70.0)));
		repo.save(new CurrencyExcchange(1003L, "USD", "SGP", new BigDecimal(60.0)));
		repo.save(new CurrencyExcchange(1004L, "SGP", "INR", new BigDecimal(67.0)));
		repo.save(new CurrencyExcchange(1005L, "INR", "DBP", new BigDecimal(50.0)));
		
	}

}
