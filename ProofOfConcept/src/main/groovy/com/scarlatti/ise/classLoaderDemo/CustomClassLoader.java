package com.scarlatti.ise.classLoaderDemo;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 */
public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    public CustomClassLoader(URLClassLoader cloneThisClassLoader) {
        super(cloneThisClassLoader.getURLs(), null);
    }
//
//    private Class<?> getClass(String name) throws ClassNotFoundException {
//        String file = File.separatorChar + name.replace('.', File.separatorChar) + ".class";
//
//        byte[] bytes = null;
//
//        try {
//            bytes = loadClassData(file);
//            Class<?> c = defineClass(name, bytes, 0, bytes.length);
//            resolveClass(c);
//            return c;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        System.out.println("loading class '" + name + "'");
//        if (!name.startsWith("java")) {
//            return getClass(name);
//        }
//        return super.loadClass(name);
//    }
//
//
//    public byte[] loadClassData(String name) throws IOException {
//        InputStream stream = getParent().getResourceAsStream(name);
//        int size = stream.available();
//        byte buff[] = new byte[size];
//        DataInputStream dataIn = new DataInputStream(stream);
//        dataIn.readFully(buff);
//        dataIn.close();
//        return buff;
//    }
}
