package com.scarlatti.ise.app.palette.rabbitmq;

import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinition;
import com.scarlatti.ise.app.scriptBuilder.model.ConnectorDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
@Configuration
public class Configurations {
    public static final String RABBITMQ_PACKAGE_NAME = "RABBITMQ";

    // TODO this will not be allowed with the addition of more packages!

    @Bean
    List<ComponentDefinition> componentDefinitions(ComponentProvider componentProvider) {
        return componentProvider.provideComponents();
    }

    @Bean
    List<ConnectorDefinition> connectorDefinitions(ConnectorProvider connectorProvider) {
        return connectorProvider.provideConnectors();
    }
}
