package com.scarlatti.ise.client

import com.scarlatti.ise.executor.SpringBootApp
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
class ClientApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class)
    }

    @Override
    public void run(String...args) {
         SpringBootApp.runInSpringBootApp { ConfigurableApplicationContext context ->
            context.getBeanFactory().registerSingleton("penguin",
                new GroovyClassLoader(this.class.getClassLoader()).parseClass("""
                    class Penguin {
                        def ork() {
                            println "ork!"
                        }
                    }
                """).newInstance()
            )

            context.getBean("penguin").ork()
        }
    }
}
