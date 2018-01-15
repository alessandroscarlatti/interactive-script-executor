package com.scarlatti.ise.app.scriptBuilder.model

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueuePropsTest
import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransferPropsTestData
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps
import com.scarlatti.ise.app.scriptBuilder.model.json.ConnectorProps
import com.scarlatti.ise.app.scriptBuilder.model.json.ScriptProps

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class ScriptPropsTestData {

    static ScriptProps nil() {
        return null
    }

    static ScriptProps empty() {
        return new ScriptProps(
                id: Id.empty(),
                components: Components.empty(),
                connectors: Connectors.empty()
        )
    }

    static ScriptProps sample1() {
        return new ScriptProps(
                id: Id.sample1(),
                components: Components.sample1(),
                connectors: Connectors.sample1()
        )
    }

    static ScriptProps sample2() {
        return new ScriptProps(
                id: Id.sample2(),
                components: Components.sample2(),
                connectors: Connectors.sample2()
        )
    }

    static ScriptProps sample3() {
        return new ScriptProps(
                id: Id.sample3(),
                components: Components.sample3(),
                connectors: Connectors.sample3()
        )
    }

    static class JSON {
        static String nil() {
            return """null"""
        }

        static String defs() {
            return """{
                    "id": "testScript",
                    "components": [
                    ], 
                    "connectors": [
                    ]
                }"""
        }

        static String empty() {
            return """{
                    "id": "${Id.empty()}",
                    "components": [
                    ], 
                    "connectors": [
                    ]
                }"""
        }

        static String sample1() {
            return """{
                    "id": "${Id.sample1()}",
                    "components": [
                        ${RabbitQueuePropsTest.Data.JSON.sample1()}
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()}
                    ]
                }"""
        }

        static String sample2() {
            return """{
                    "id": "${Id.sample2()}",
                    "components": [
                        ${RabbitQueuePropsTest.Data.JSON.sample1()},
                        ${RabbitQueuePropsTest.Data.JSON.sample2()}
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()},
                        ${MessageTransferPropsTestData.JSON.sample2()}
                    ]
                }"""
        }

        static String sample3() {
            return """{
                    "id": "${Id.sample3()}",
                    "components": [
                        ${RabbitQueuePropsTest.Data.JSON.sample1()},
                        ${RabbitQueuePropsTest.Data.JSON.sample2()},
                        ${RabbitQueuePropsTest.Data.JSON.sample3()}
                    ], 
                    "connectors": [
                        ${MessageTransferPropsTestData.JSON.sample1()},
                        ${MessageTransferPropsTestData.JSON.sample2()},
                        ${MessageTransferPropsTestData.JSON.sample3()}
                    ]
                }"""
        }
    }

    static class Id {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "rabbitQueueScript"
        }

        static String sample2() {
            return "databaseScript"
        }

        static String sample3() {
            return "restScript"
        }
    }

    static class Components {
        static List<ComponentProps> nil() {
            return null
        }

        static List<ComponentProps> empty() {
            return new ArrayList<ComponentProps>()
        }

        static List<ComponentProps> sample1() {
            return [
                    RabbitQueuePropsTest.Data.sample1()
            ]
        }

        static List<ComponentProps> sample2() {
            return [
                    RabbitQueuePropsTest.Data.sample1(),
                    RabbitQueuePropsTest.Data.sample2()
            ]
        }

        static List<ComponentProps> sample3() {
            return [
                    RabbitQueuePropsTest.Data.sample1(),
                    RabbitQueuePropsTest.Data.sample2(),
                    RabbitQueuePropsTest.Data.sample3(),
            ]
        }
    }

    static class Connectors {
        static List<ConnectorProps> nil() {
            return null
        }

        static List<ConnectorProps> empty() {
            return new ArrayList<>()
        }

        static List<ConnectorProps> sample1() {
            return [
                    MessageTransferPropsTestData.sample1()
            ]
        }

        static List<ConnectorProps> sample2() {
            return [
                    MessageTransferPropsTestData.sample1(),
                    MessageTransferPropsTestData.sample2()
            ]
        }

        static List<ConnectorProps> sample3() {
            return [
                    MessageTransferPropsTestData.sample1(),
                    MessageTransferPropsTestData.sample2(),
                    MessageTransferPropsTestData.sample3(),
            ]
        }
    }
}