package com.demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudPrometheusApplication {

	final static Logger logger = LoggerFactory.getLogger(SpringCloudPrometheusApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPrometheusApplication.class, args);
	}
	@GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        logger.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }

}
//docker run -it -p 9090:9090 -v ./data/prometheus/config:/etc/prometheus/prometheus.yaml prom/prometheus

