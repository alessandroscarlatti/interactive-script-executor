package com.scarlatti.ise.app.scriptExecutor.model;

import com.scarlatti.ise.app.scriptBuilder.model.ISEComponent;
import com.scarlatti.ise.app.scriptBuilder.model.ISEConnector;
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutionResult;
import com.scarlatti.ise.script.ISEScriptApplication;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 * <p>
 * Wrap the SpringContext so that I can more easily
 * control how my components can and can't access it.
 */
public class ISEScriptContext {
    private ConfigurableListableBeanFactory beanFactory;

    public ISEScriptContext(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

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
     * Register any object with the Spring application context.
     * under the given ID.
     * @param name the ID to assign to the bean
     * @param object the object to add to the Spring context.
     */
    public void registerSingletonObject(String name, Object object) {
        beanFactory.registerSingleton(name, object);
    }

    /**
     * Register any object with the Spring application context.
     * under an automatically generated hash code ID.
     *
     * @param object the object to add to the Spring context.
     */
    public void registerSingletonObject(Object object) {
        beanFactory.registerSingleton("object" + System.identityHashCode(object), object);
    }

    /**
     * Try to pull a bean from the Spring context with the
     * given name and given class.
     *
     * @param qualifier the name to look for
     * @param clazz     the class to expect
     * @param <T>       the class to expect
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

    /**
     * Run the script in a new ISEScriptContext, and execute the
     * actions specified in the provided callback
     * @param callback code passed in to be run for context initialization
     * @return the result of the callback
     */
    public static ScriptExecutionResult run(ISEScriptContextCallback callback) {

        ScriptExecutionResult result = new ScriptExecutionResult();

        ISEScriptApplication.run(beanFactory -> {
            ISEScriptContext context = new ISEScriptContext(beanFactory);
            callback.doInContext(context);
            result.setStatusCode(0);
        });

        return result;
    }

    /**
     * Interface for the user to have called back
     * when the script context is ready for initialization.
     */
    @FunctionalInterface
    public interface ISEScriptContextCallback {
        /**
         * Method to be called when the script context is
         * ready to be initialized with component and connector beans.
         * @param context the script context, ready to be initialized
         * @return the ScriptExecutionResult for this script.
         */
        ScriptExecutionResult doInContext(ISEScriptContext context);
    }
}
