package com.scarlatti.ise.app.scriptExecutor

import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ScriptExecutionResultTest extends Specification {

    static class Data {
        static ScriptExecutionResult nil() {
            return null
        }

        static ScriptExecutionResult empty() {
            return new ScriptExecutionResult()
        }

        static ScriptExecutionResult defs() {
            return new ScriptExecutionResult()
        }

        static ScriptExecutionResult sample1() {
            return new ScriptExecutionResult(
                    statusCode: -1
            )
        }

        static ScriptExecutionResult sample2() {
            return new ScriptExecutionResult(
                    statusCode: 1
            )
        }

        static ScriptExecutionResult sample3() {
            return new ScriptExecutionResult(
                    statusCode: 3
            )
        }
    }
}
