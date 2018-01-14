package com.scarlatti.ise.scriptBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scarlatti.ise.scriptBuilder.exceptions.ScriptMappingException;
import com.scarlatti.ise.scriptBuilder.model.ISEComponent;
import com.scarlatti.ise.scriptBuilder.model.ISEConnector;
import com.scarlatti.ise.scriptBuilder.model.ISEScript;
import com.scarlatti.ise.scriptBuilder.model.json.ComponentProps;
import com.scarlatti.ise.scriptBuilder.model.json.ConnectorProps;
import com.scarlatti.ise.scriptBuilder.model.json.ScriptProps;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 *
 * The script builder service is responsible for taking in JSON
 * and turning it into a ScriptProps object.
 *
 * There may be some overlaying of properties against
 * a sensible default before they are parsed into
 * the script.
 */
public class ScriptBuilderService {

    private ObjectMapper objectMapper;
    private ComponentFactory componentFactory;
    private ConnectorFactory connectorFactory;

    public ScriptBuilderService(ObjectMapper objectMapper, ComponentFactory componentFactory, ConnectorFactory connectorFactory) {
        this.objectMapper = objectMapper;
        this.componentFactory = componentFactory;
    }

    public ISEScript buildScript(String json) {
        return buildScript(buildScriptProps(json));
    }

    /**
     * The ScriptBuilderService should interpret the script props
     * and return a script object, ready to be executed.
     *
     * @param scriptProps the script props to interpret.
     * @return the script, ready to be executed.
     */
    public ISEScript buildScript(ScriptProps scriptProps) {
        // this is where we take each componentProps
        // and send its getComponentType to the component factory
        // we add a new instance of the component (connected with its props)
        // to the working script.
        ISEScript workingScript = new ISEScript(scriptProps.getId());

        for (ComponentProps props : scriptProps.getComponents()) {
            ISEComponent component = componentFactory.getComponent(props.componentType(), props);
            workingScript.getComponents().add(component);
        }

        // then we do similarly with the connectors

        for (ConnectorProps props : scriptProps.getConnectors()) {
            ISEConnector connector = connectorFactory.getConnector(props.connectorType(), props);
            workingScript.getConnectors().add(connector);
        }

        return workingScript;
    }

    /**
     *
     * @param json the JSON to parse
     * @return the ScriptProps object interpreted from the JSON
     */
    public ScriptProps buildScriptProps(String json) {
        try {
            return objectMapper.readValue(json, ScriptProps.class);
        } catch (Exception e) {
            throw new ScriptMappingException("Error mapping json to ScriptProps.", e, json);
        }
    }
}
