package com.scarlatti.ise.app.scriptBuilder.model

import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransfer
import com.scarlatti.ise.app.palette.rabbitmq.model.MessageTransferProps
import com.scarlatti.ise.app.scriptBuilder.ConnectorFactoryTest
import com.scarlatti.ise.app.scriptBuilder.model.json.ConnectorProps
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ConnectorDefinitionTest extends Specification {
    static class Data {
        static ConnectorDefinition nil() {
            return new ConnectorDefinition() {
                @Override
                ISEConnector provideConnector(ConnectorProps props) {
                    return null
                }

                @Override
                String forType() {
                    return null
                }
            }
        }

        static ConnectorDefinition sample1() {
            return new ConnectorDefinition() {
                @Override
                public ISEConnector provideConnector(ConnectorProps props) {
                    return new MessageTransfer((MessageTransferProps)props);
                }

                @Override
                public String forType() {
                    return MessageTransferProps.CONNECTOR_NAME;
                }
            }
        }

        static ConnectorDefinition sample2() {
            return new ConnectorDefinition() {
                @Override
                public ISEConnector provideConnector(ConnectorProps props) {
                    return new MessageTransfer((MessageTransferProps)props);
                }

                @Override
                public String forType() {
                    return ConnectorFactoryTest.Data.ConnectorType.sample2()
                }
            }
        }

        static ConnectorDefinition sample3() {
            return new ConnectorDefinition() {
                @Override
                public ISEConnector provideConnector(ConnectorProps props) {
                    return new MessageTransfer((MessageTransferProps)props);
                }

                @Override
                public String forType() {
                    return ConnectorFactoryTest.Data.ConnectorType.sample3()
                }
            }
        }
    }
}
