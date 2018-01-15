package com.scarlatti.ise.app.scriptBuilder

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueuePropsTest
import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransferPropsTestData
import com.scarlatti.ise.app.scriptBuilder.model.ScriptPropsTestData
import com.scarlatti.ise.app.scriptBuilder.model.json.ScriptProps

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
                        ${RabbitQueuePropsTest.Data.JSON.sample1()},
                        ${RabbitQueuePropsTest.Data.JSON.sample2()}
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
                        ${RabbitQueuePropsTest.Data.JSON.sample1()},
                        ${RabbitQueuePropsTest.Data.JSON.sample2()},
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()},,,,,,,
                    ]
                }"""
            }
        }

        static class Return {
            static ScriptProps sample1() {
                return new ScriptProps(
                        id: ScriptPropsTestData.Id.sample1(),
                        components: ScriptPropsTestData.Components.sample2(),
                        connectors: ScriptPropsTestData.Connectors.sample1()
                )
            }
        }
    }
}
