package com.scarlatti.ise.app.scriptBuilder.exceptions;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class ComponentFactoryException extends RuntimeException {
    private String componentType;

    public ComponentFactoryException(String componentType) {
        this.componentType = componentType;
    }

    public ComponentFactoryException(String message, String componentType) {
        super(message);
        this.componentType = componentType;
    }

    public ComponentFactoryException(String message, Throwable cause, String componentType) {
        super(message, cause);
        this.componentType = componentType;
    }

    @Override
    public String toString() {
        return super.toString() + "...componentType: " + componentType;
    }
}
