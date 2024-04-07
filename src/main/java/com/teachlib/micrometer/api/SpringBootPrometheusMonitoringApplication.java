package com.teachlib.micrometer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootPrometheusMonitoringApplication {
	@GetMapping("/hello")
	public String getMessage(){
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrometheusMonitoringApplication.class, args);
	}

}
