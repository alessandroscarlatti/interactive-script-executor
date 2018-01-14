package com.scarlatti.ise.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ISEScriptApplication implements CommandLineRunner {

	private static BeanInitializerCallback callback;

	private static final Logger log = LoggerFactory.getLogger(ISEScriptApplication.class);

	public static void run(BeanInitializerCallback callback) {
		ISEScriptApplication.callback = callback;
		SpringApplication.run(ISEScriptApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("This is an INFO level log");
		log.debug("This is an DEBUG level log");
		log.error("This is an ERROR level log");
	}

	@FunctionalInterface
	public interface BeanInitializerCallback {
		void callback(ConfigurableListableBeanFactory beanFactory);
	}

	protected static BeanInitializerCallback getCallback() {
		return callback;
	}
}
