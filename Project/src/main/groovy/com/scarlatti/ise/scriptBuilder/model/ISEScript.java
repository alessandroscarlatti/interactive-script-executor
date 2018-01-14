package com.scarlatti.ise.scriptBuilder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
public class ISEScript {
    private String id;
    private List<ISEComponent> components = new ArrayList<>();
    private List<ISEConnector> connectors = new ArrayList<>();

    public ISEScript(String id) {
        this.id = id;
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

    public List<ISEComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ISEComponent> components) {
        this.components = components;
    }

    public List<ISEConnector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<ISEConnector> connectors) {
        this.connectors = connectors;
    }
}
