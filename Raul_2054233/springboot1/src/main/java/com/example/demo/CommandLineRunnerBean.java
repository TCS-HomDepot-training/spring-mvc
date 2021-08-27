package com.example.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandLineRunnerBean implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(CommandLineRunnerBean.class);

	@Override
	public void run(String... args) throws Exception {

		String collectStr = Arrays.stream(args).collect(Collectors.joining(","));

		logger.info(collectStr);
	}

}
