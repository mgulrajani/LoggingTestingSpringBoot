package com.training.loggingtesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingtestingApplication {
	private static final Logger LOGGER= LoggerFactory.getLogger(LoggingtestingApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(LoggingtestingApplication.class, args);

		LOGGER.info("Simple log statement with inputs  {} {} {}","data1","data2","data3");
	}

}
