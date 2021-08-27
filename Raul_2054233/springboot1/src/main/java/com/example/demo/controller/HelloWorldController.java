package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloWorldController {
	
    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


	@RequestMapping("/")
	public String hello() {
		
	    logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		logger.info("WELCOME TO THE WORLD OF SPRING on http://localhost:9869/bootcamp/demo/");
		
		return "WELCOME TO THE WORLD OF SPRING";
		
	}
}