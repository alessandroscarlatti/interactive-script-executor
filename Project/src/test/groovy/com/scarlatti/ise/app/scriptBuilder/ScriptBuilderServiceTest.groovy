package com.scarlatti.ise.app.scriptBuilder

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.app.scriptBuilder.exceptions.ScriptMappingException
import com.scarlatti.ise.app.scriptBuilder.model.ScriptPropsTestData
import com.scarlatti.ise.app.scriptBuilder.model.json.ScriptProps
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ScriptBuilderServiceTest extends Specification {
    @Unroll
    "parse Script from JSON #json"(String json, ScriptProps expectedScript) {
        when:
            ScriptProps script = new ObjectMapper().readValue(json, ScriptProps.class)
        then:
            script != null
            script.class == ScriptProps
            script == expectedScript
        where:
            json                               | expectedScript
            ScriptPropsTestData.JSON.sample1() | ScriptPropsTestData.sample1()
            ScriptPropsTestData.JSON.sample2() | ScriptPropsTestData.sample2()
            ScriptPropsTestData.JSON.sample3() | ScriptPropsTestData.sample3()
    }

    @Unroll
    "throw exception on parse Script from JSON #json"(String json) {
        setup:
            ScriptBuilderService scriptBuilderService = Data.mocked()
        when:
            scriptBuilderService.buildScriptProps(json)
        then:
            ScriptMappingException e = thrown()
            e.json == json
            e.printStackTrace()
        where:
            json << [ScriptBuilderServiceTestData.BuildScript.Json.err1()]
    }

    static class Data {
        static ScriptBuilderService mocked() {
            return new ScriptBuilderService(
                    new ObjectMapper(),
                    ComponentFactoryTest.Data.mocked(),
                    ConnectorFactoryTest.Data.mocked()
            )
        }

        static Closure<ScriptBuilderService> spy = { Specification test ->
            return test.Spy(ScriptBuilderService, constructorArgs: [
                    new ObjectMapper(),
                    ComponentFactoryTest.Data.mocked(),
                    ConnectorFactoryTest.Data.mocked()
            ])
        }
    }
}
