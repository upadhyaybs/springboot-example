package com.bsu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingsController {
	
	@GetMapping
	public String greeting() {
		return "Hello ! This is Spring Boot Demo App.";
	}

}
