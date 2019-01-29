package com.sample.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	static Logger log =LoggerFactory.getLogger(BookstoreController.class);
	
	@RequestMapping(value = "/hello")
	  public String sayHello(){
		log.info("class:DemoController;event:say Hello");
	    return "Hello !! This is Spring Boot Demo App";
	  }

}
