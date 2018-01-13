package com.scarlatti.ise.scriptBuilder

import com.scarlatti.ise.palette.rabbitmq.model.components.RabbitQueuePropsTestData
import com.scarlatti.ise.palette.rabbitmq.model.connectors.MessageTransferPropsTestData
import com.scarlatti.ise.scriptBuilder.model.Script
import com.scarlatti.ise.scriptBuilder.model.ScriptPropsTestData

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ScriptBuilderServiceTestData {
    static class BuildScript {
        static class Json {
            static String sample1() {
                return """{
                    "id": "${ScriptPropsTestData.Id.sample2()}",
                    "components": [
                        ${RabbitQueuePropsTestData.JSON.sample1()},
                        ${RabbitQueuePropsTestData.JSON.sample2()}
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()}
                    ]
                }"""
            }

            static String err1() {
                return """{
                    "id": "${ScriptPropsTestData.Id.sample3()}",
                    "components": [
                        ${RabbitQueuePropsTestData.JSON.sample1()},
                        ${RabbitQueuePropsTestData.JSON.sample2()},
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()},,,,,,,
                    ]
                }"""
            }
        }

        static class Return {
            static Script sample1() {
                return new Script(
                        id: ScriptPropsTestData.Id.sample1(),
                        components: ScriptPropsTestData.Components.sample2(),
                        connectors: ScriptPropsTestData.Connectors.sample1()
                )
            }
        }
    }
}
