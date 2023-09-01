package com.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//to refresh the profile
//http://localhost:8080/actuator/refresh
@SpringBootApplication
public class ConfigServerClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerClientApplication.class, args);
	}
}
