package com.scarlatti.ise.scriptBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public ScriptBuilderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
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
