package com.scarlatti.ise.script;

import com.scarlatti.ise.app.scriptExecutor.model.ISEScriptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 */
@Component
public class BeanInitializer implements BeanFactoryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(BeanInitializer.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Initializing Script beans.");
        beanFactory.registerSingleton("special", new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("yay!!");
            }
        });

        // so now I can pull dependencies from the bean factory
        // and build my own beans before the application officially starts!

        ISEScriptApplication.getCallback().callback(beanFactory);
    }
}
