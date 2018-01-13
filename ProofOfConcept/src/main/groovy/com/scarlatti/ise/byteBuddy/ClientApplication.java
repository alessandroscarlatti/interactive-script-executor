package com.scarlatti.ise.byteBuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.MethodCall;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 */
public class ClientApplication {
    public static void main(String[] args) throws Exception {
        // create the component class with bytebuddy
        // then start Spring...

        Object object = new ByteBuddy().subclass(Object.class)
            .implement(CommandLineRunner.class)
            .name("com.scarlatti.ise.byteBuddy.AppConfig")
            .annotateType(
                AnnotationDescription.Builder.ofType(Component.class)
                    .define("value", "specialCommandLineRunner").build()
            )
            .defineMethod("run", void.class, Visibility.PUBLIC)
            .withParameters(String[].class)
            .intercept(MethodCall.invoke(ClientApplication.class.getMethod("ork")))
            .make()
            .load(ClientApplication.class.getClassLoader())
            .getLoaded()
            .newInstance();

        object.getClass().getMethod("run", String[].class).invoke(object, new Object[]{new String[]{}});



        SpringApplication.run(SpringBootApp.class);
    }

    // this method could be loaded dynamically...
    public static void ork() {
        System.out.println("ork!");
    }

}
