package com.scarlatti.ise.classLoaderDemo;

import java.net.URLClassLoader;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = new CustomClassLoader((URLClassLoader)ClassLoaderDemo.class.getClassLoader());

        Object obj = classLoader.loadClass("com.scarlatti.ise.classLoaderDemo.SpringBootAppRunner").newInstance();

        Thread.currentThread().setContextClassLoader(classLoader);

        obj.getClass().getMethod("run").invoke(obj);

    }
}
