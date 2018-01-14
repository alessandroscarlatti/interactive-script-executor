package com.scarlatti.ise.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ISEApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ISEApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ISEApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("This is an INFO level log");
		log.debug("This is an DEBUG level log");
		log.error("This is an ERROR level log");
	}
}
