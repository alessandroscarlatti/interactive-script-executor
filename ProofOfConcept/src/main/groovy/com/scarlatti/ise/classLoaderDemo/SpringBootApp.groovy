package com.scarlatti.ise.classLoaderDemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

	@Autowired
	SimpleScriptRunnerDemo simpleScriptRunner

	private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

	public static void start() {
		System.out.println("main classloader is: " + SpringBootApp.class.getClassLoader());
		SpringApplication.run(SpringBootApp.class);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("This is an INFO level log");
		log.debug("This is an DEBUG level log");
		log.error("This is an ERROR level log");

		simpleScriptRunner.runClass("""
			package com.scarlatti.ise;
			
			import org.springframework.boot.CommandLineRunner;
			import org.springframework.boot.SpringApplication;
			import org.springframework.boot.autoconfigure.SpringBootApplication;
	
			@SpringBootApplication
			public class SpringBootApp2 implements CommandLineRunner {
		
				public static void start() {
					System.out.println("main classloader is: " + SpringBootApp2.class.getClassLoader());
					SpringApplication.run(SpringBootApp2.class);
				}
	
				@Override
				public void run(String... args) throws Exception {
					log.info("This is an INFO level log");
					log.debug("This is an DEBUG level log");
					log.error("This is an ERROR level log");
				}
			}
		""")

//
//		System.out.println("command line runner classloader is: " + this.getClass().getClassLoader());
//		ClassLoader classLoader = new CustomClassLoader((URLClassLoader)ClassLoaderDemo.class.getClassLoader());
//
//		Object obj = classLoader.loadClass("com.scarlatti.ise.client.SpringBootAppRunner").newInstance();
//
//		Thread.currentThread().setContextClassLoader(classLoader);
//
//		obj.getClass().getMethod("run").invoke(obj);

	}
}
