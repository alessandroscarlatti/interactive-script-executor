package com.scarlatti.ise.app.palette.rabbitmq;

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueue;
import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinition;
import com.scarlatti.ise.app.scriptBuilder.model.PackageComponentProvider;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
@Component
public class ComponentProvider implements PackageComponentProvider {


    @Override
    public String providePackageId() {
        return Configurations.RABBITMQ_PACKAGE_NAME;
    }

    @Override
    public List<ComponentDefinition> provideComponents() {
        return Collections.singletonList(new RabbitQueue.DefaultComponentDefinition());
    }
}
