package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoPortApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(DemoPortApplication.class);
	
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(DemoPortApplication.class, args);
        LOG.info("APPLICATION RUNNING");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("WELCOME TO THE WORLD OF SPRING");
		LOG.info("EXECUTING : command line runner");
		 
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
	}

}
