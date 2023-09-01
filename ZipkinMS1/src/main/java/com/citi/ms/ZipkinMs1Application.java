package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//[MS1,78ac913e96e9728b,78ac913e96e9728b]
// [MS2,78ac913e96e9728b,322e2ec9193b13dc]
//[MS3,78ac913e96e9728b,d11da5983d343b2f]

@SpringBootApplication
public class ZipkinMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinMs1Application.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate template()
	{
		return new RestTemplate();
	}
}
