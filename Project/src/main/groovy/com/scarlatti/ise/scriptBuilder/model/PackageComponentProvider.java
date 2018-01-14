package com.scarlatti.ise.scriptBuilder.model;

import com.scarlatti.ise.scriptBuilder.model.json.ComponentProps;
import com.scarlatti.ise.scriptExecutor.model.ISEScriptContext;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public interface PackageComponentProvider {

    String providePackageId();
    List<ComponentDefinition> provideComponents();
}
