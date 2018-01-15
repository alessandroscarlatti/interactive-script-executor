package com.scarlatti.ise.app.scriptExecutor

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.app.scriptBuilder.ComponentFactoryTest
import com.scarlatti.ise.app.scriptBuilder.ConnectorFactoryTest
import com.scarlatti.ise.app.scriptBuilder.ScriptBuilderService
import com.scarlatti.ise.app.scriptBuilder.model.ISEScript
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
class ScriptExecutorServiceTest extends Specification {

    ScriptBuilderService scriptBuilderService = Spy(ScriptBuilderService, constructorArgs: [
            new ObjectMapper(),
            ComponentFactoryTest.Data.mocked(),
            ConnectorFactoryTest.Data.mocked()
    ])

    ScriptExecutorService scriptExecutorService = Spy(ScriptExecutorService, constructorArgs: [scriptBuilderService])

    @Unroll
    "executes script from ScriptBuilderService"(Closure execute) {
        when:
            _ * scriptBuilderService.buildScriptProps(_ as String) >> { ScriptPropsTestData.sample1()}
            _ * scriptBuilderService.buildScript(_ as ScriptProps) >> { new ISEScript("asdf") }
            _ * scriptExecutorService.doExecute(_ as ISEScript) >> { ScriptExecutionResultTest.Data.sample1()}
        then:
            execute(scriptExecutorService) == ScriptExecutionResultTest.Data.sample1()
        where:
            execute << [
                    {service -> service.execute(ScriptPropsTestData.JSON.sample1())},
                    {service -> service.execute(ScriptPropsTestData.sample1())}
            ]
    }

    static class Data {

    }
}
