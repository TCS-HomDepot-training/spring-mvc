package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.service.MessageService;

@SpringBootApplication
public class SpringBootHelloWorldExampleApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(SpringBootHelloWorldExampleApplication.class);

		System.setProperty("server.servlet.context-path", "/bootcamp/demo");
		ConfigurableApplicationContext configurableApplicationContext=	SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);
		MessageService messageService=configurableApplicationContext.getBean(MessageService.class);
		
		String message=messageService.message();
		logger.info(message);
	}
}