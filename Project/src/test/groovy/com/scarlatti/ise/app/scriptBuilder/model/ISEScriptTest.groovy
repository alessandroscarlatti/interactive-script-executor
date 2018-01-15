package com.scarlatti.ise.app.scriptBuilder.model

import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Monday, 1/15/2018
 */
class ISEScriptTest extends Specification {
    static class Data {
        static ISEScript sample1() {
            return new ISEScript(
                    id: ScriptPropsTestData.Id.sample1(),
                    components: Components.sample1(),
                    connectors: Connectors.sample1()
            )
        }

        static ISEScript sample2() {
            return new ISEScript(
                    id: ScriptPropsTestData.Id.sample2(),
                    components: Components.sample2(),
                    connectors: Connectors.sample2()
            )
        }

        static ISEScript sample3() {
            return new ISEScript(
                    id: ScriptPropsTestData.Id.sample3(),
                    components: Components.sample3(),
                    connectors: Connectors.sample3()
            )
        }

        static class Components {
            static List<ISEComponent> sample1() {
                return [
                        ISEComponentTest.Data.sample1(),
                        ISEComponentTest.Data.sample2()
                ]
            }

            static List<ISEComponent> sample2() {
                return [
                        ISEComponentTest.Data.sample1(),
                        ISEComponentTest.Data.sample2(),
                        ISEComponentTest.Data.sample3()
                ]
            }

            static List<ISEComponent> sample3() {
                return [
                        ISEComponentTest.Data.sample1(),
                        ISEComponentTest.Data.sample2(),
                        ISEComponentTest.Data.sample3(),
                        ISEComponentTest.Data.sample4()
                ]
            }
        }

        static class Connectors {
            static List<ISEConnector> sample1() {
                return [
                        ISEConnectorTest.Data.sample1()
                ]
            }

            static List<ISEConnector> sample2() {
                return [
                        ISEConnectorTest.Data.sample1(),
                        ISEConnectorTest.Data.sample2()
                ]
            }

            static List<ISEConnector> sample3() {
                return [
                        ISEConnectorTest.Data.sample1(),
                        ISEConnectorTest.Data.sample2(),
                        ISEConnectorTest.Data.sample3()
                ]
            }
        }
    }
}
