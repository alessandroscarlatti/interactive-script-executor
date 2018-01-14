package com.scarlatti.ise.app.scriptBuilder.exceptions;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class ConnectorFactoryException extends RuntimeException {
    private String connectorType;

    public ConnectorFactoryException(String connectorType) {
        this.connectorType = connectorType;
    }

    public ConnectorFactoryException(String message, String connectorType) {
        super(message);
        this.connectorType = connectorType;
    }

    public ConnectorFactoryException(String message, Throwable cause, String connectorType) {
        super(message, cause);
        this.connectorType = connectorType;
    }

    @Override
    public String toString() {
        return super.toString() + "...connectorType: " + connectorType;
    }
}
