package com.scarlatti.ise.app.scriptBuilder;

import com.scarlatti.ise.app.scriptBuilder.exceptions.ComponentFactoryException;
import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinition;
import com.scarlatti.ise.app.scriptBuilder.model.ISEComponent;
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
@Component
public class ComponentFactory {

    private List<ComponentDefinition> componentDefinitions;

    public ComponentFactory(List<ComponentDefinition> componentDefinitions) {
        this.componentDefinitions = componentDefinitions;
    }

    public ISEComponent getComponent(String type, ComponentProps props) {
        return getComponent(getComponentDefinition(type), props);
    }

    public ISEComponent getComponent(ComponentDefinition definition, ComponentProps props) {
        return definition.provideComponent(props);
    }

    public ComponentDefinition getComponentDefinition(String type) {
        for (ComponentDefinition definition  : componentDefinitions) {
            if (definition.forType().equals(type)) {
                return definition;
            }
        }

        throw new ComponentFactoryException("Component not found.", type);
    }
}
