package com.scarlatti.ise.scriptExecutor.model;

import com.scarlatti.ise.scriptBuilder.model.ISEComponent;
import com.scarlatti.ise.scriptBuilder.model.ISEConnector;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 *
 * Wrap the SpringContext so that I can more easily
 * control how my components can and can't access it.
 */
public class ISEScriptContext {
    private ConfigurableListableBeanFactory beanFactory;

    /**
     * Register this component instance with the Spring
     * application context under the component's ID.
     *
     * @param component the component to add to the Spring context.
     */
    public void registerSingletonComponent(ISEComponent component) {
        beanFactory.registerSingleton(component.provideId(), component);
    }

    /**
     * Register this connector instance with the Spring
     * application context under the component's ID.
     *
     * @param connector the component to add to the Spring context.
     */
    public void registerSingletonConnnector(ISEConnector connector) {
        beanFactory.registerSingleton(connector.provideId(), connector);
    }

    /**
     * Try to pull a bean from the Spring context with the
     * given name and given class.
     *
     * @param qualifier the name to look for
     * @param clazz the class to expect
     * @param <T> the class to expect
     * @return the Spring bean with the given name
     */
    public <T> T require(String qualifier, Class<T> clazz) {
        try {
            return beanFactory.getBean(qualifier, clazz);
        } catch (NoSuchBeanDefinitionException e) {
            throw new RuntimeException("Unable to retrieve bean with name " + qualifier + " and class " + clazz);
        }
    }

    /**
     * Try to pull a bean from the Spring context with
     * the given name.
     *
     * @param qualifier the name to look for.
     * @return the Spring bean with the given name.
     */
    public Object require(String qualifier) {
        try {
            return beanFactory.getBean(qualifier);
        } catch (NoSuchBeanDefinitionException e) {
            throw new RuntimeException("Unable to retrieve bean with name " + qualifier + ".");
        }
    }
}
