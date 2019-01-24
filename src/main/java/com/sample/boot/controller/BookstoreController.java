package com.sample.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {
	
	static Logger log =LoggerFactory.getLogger(BookstoreController.class);
	
	@RequestMapping(value = "/recommended")
	  public String readingList(){
		log.info("class:BookstoreController;event:readingList First Check-in");
	    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	  }

}
