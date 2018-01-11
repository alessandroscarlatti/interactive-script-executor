package com.scarlatti.ise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("This is an INFO level log");
		log.debug("This is an DEBUG level log");
		log.error("This is an ERROR level log");
	}
}
