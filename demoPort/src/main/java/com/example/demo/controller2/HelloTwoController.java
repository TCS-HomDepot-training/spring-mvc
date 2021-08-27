package com.example.demo.controller2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTwoController {

	private static final Logger LOG = LoggerFactory.getLogger(HelloTwoController.class);
	
	@GetMapping("/two")
	public String index() {
		LOG.trace("This is a TRACE log");
        LOG.debug("This is a DEBUG log");
        LOG.info("This is an INFO log");
        LOG.error("This is an ERROR log");

		return "<h1>Hello World!</h1>";
	}

}