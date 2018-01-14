package com.scarlatti.ise.scriptBuilder;

import com.scarlatti.ise.scriptBuilder.exceptions.ConnectorFactoryException;
import com.scarlatti.ise.scriptBuilder.model.ConnectorDefinition;
import com.scarlatti.ise.scriptBuilder.model.ISEConnector;
import com.scarlatti.ise.scriptBuilder.model.json.ConnectorProps;
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
public class ConnectorFactory {

    private List<ConnectorDefinition> connectorDefinitions;

    public ConnectorFactory(List<ConnectorDefinition> connectorDefinitions) {
        this.connectorDefinitions = connectorDefinitions;
    }

    public ISEConnector getConnector(String type, ConnectorProps props) {
        return getConnector(getConnectorDefinition(type), props);
    }

    public ISEConnector getConnector(ConnectorDefinition definition, ConnectorProps props) {
        return definition.provideConnector(props);
    }

    public ConnectorDefinition getConnectorDefinition(String connectorType) {
        for (ConnectorDefinition definition  : connectorDefinitions) {
            if (definition.forType().equals(connectorType)) {
                return definition;
            }
        }

        throw new ConnectorFactoryException("Connector not found.", connectorType);
    }
}
