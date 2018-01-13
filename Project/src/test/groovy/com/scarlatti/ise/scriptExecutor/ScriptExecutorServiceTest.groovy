package com.scarlatti.ise.scriptExecutor

import com.scarlatti.ise.scriptBuilder.ScriptBuilderService
import com.scarlatti.ise.scriptBuilder.model.ScriptPropsTestData
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

    @Unroll
    "executes script from ScriptBuilderService"(Closure execute) {
        setup:
            ScriptBuilderService scriptBuilderService = Mock(ScriptBuilderService)
            ScriptExecutorService scriptExecutorService = Spy(ScriptExecutorService, constructorArgs: [scriptBuilderService])

            _ * scriptBuilderService.buildScriptProps(_) >> { return ScriptPropsTestData.sample1()}
        when:
            execute(scriptExecutorService)
        then:
            1 * scriptExecutorService.execute(ScriptPropsTestData.sample1())
        where:
            execute << [
                    {service -> service.execute(ScriptPropsTestData.JSON.sample1())},
                    {service -> service.execute(ScriptPropsTestData.sample1())}
            ]
    }

    static class Data {

    }
}
