package com.scarlatti.ise.executor

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 */
@SpringBootApplication
class SpringBootApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

    public static ConfigurableApplicationContext runInSpringBootApp(Closure callback) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp.class)
        callback(context)
        context.close()
    }

    @Override
    void run(String... args) throws Exception {
        log.info("Executor...")
    }
}
