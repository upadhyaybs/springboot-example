package com.codify.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringBootDemoApplication {
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
    private String appName;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@GetMapping("/index")
	public String index() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}
	
}
