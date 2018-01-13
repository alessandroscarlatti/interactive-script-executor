package com.scarlatti.ise.scriptBuilder;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class ScriptMappingException extends RuntimeException {
    private String json;

    public ScriptMappingException(String json) {
        this.json = json;
    }

    public ScriptMappingException(String message, String json) {
        super(message);
        this.json = json;
    }

    public ScriptMappingException(String message, Throwable cause, String json) {
        super(message, cause);
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    @Override
    public String toString() {
        return super.toString() + "...JSON was: " + json;
    }
}
