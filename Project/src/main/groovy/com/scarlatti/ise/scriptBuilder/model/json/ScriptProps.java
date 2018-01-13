package com.scarlatti.ise.scriptBuilder.model.json;

import java.util.List;
import java.util.Objects;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
public class ScriptProps {
    private String id;
    private List<ComponentProps> components;
    private List<ConnectorProps> connectors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptProps scriptProps = (ScriptProps) o;
        return Objects.equals(id, scriptProps.id) &&
            Objects.equals(components, scriptProps.components) &&
            Objects.equals(connectors, scriptProps.connectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, components, connectors);
    }

    @Override
    public String toString() {
        return "ScriptProps{" +
            "id='" + id + '\'' +
            ", components=" + components +
            ", connectors=" + connectors +
            '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ComponentProps> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentProps> components) {
        this.components = components;
    }

    public List<ConnectorProps> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<ConnectorProps> connectors) {
        this.connectors = connectors;
    }
}
