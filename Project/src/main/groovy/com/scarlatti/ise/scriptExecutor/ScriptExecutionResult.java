package com.scarlatti.ise.scriptExecutor;

import java.util.Objects;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class ScriptExecutionResult {
    private int statusCode;

    public ScriptExecutionResult() {
    }

    public ScriptExecutionResult(int statusCode) {
        this.statusCode = statusCode;
    }

    public ScriptExecutionResult(ScriptExecutionResult other) {
        this.statusCode = other.statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptExecutionResult that = (ScriptExecutionResult) o;
        return statusCode == that.statusCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode);
    }

    @Override
    public String toString() {
        return "ScriptExecutionResult{" +
            "statusCode=" + statusCode +
            '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
