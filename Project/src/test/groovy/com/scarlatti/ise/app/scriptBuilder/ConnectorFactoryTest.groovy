package com.scarlatti.ise.app.scriptBuilder

import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransfer
import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransferProps
import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransferPropsTestData
import com.scarlatti.ise.app.scriptBuilder.exceptions.ConnectorFactoryException
import com.scarlatti.ise.app.scriptBuilder.model.ConnectorDefinition
import com.scarlatti.ise.app.scriptBuilder.model.ConnectorDefinitionTest
import com.scarlatti.ise.app.scriptBuilder.model.ISEConnector
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ConnectorFactoryTest extends Specification {

    @Unroll
        "return correct connector for connector type: #connectorType"(String connectorType) {
        setup:
            ConnectorFactory connectorFactory = Data.mocked()
        when:
            ISEConnector connector = connectorFactory.getConnector(connectorType, MessageTransferPropsTestData.sample1())
        then:
            connector != null
            connector instanceof MessageTransfer
        where:
            connectorType = Data.ConnectorType.sample1()
    }

    @Unroll
    "exception thrown for unrecognized connector type: #connectorType"(String connectorType) {
        setup:
            ConnectorFactory connectorFactory = Data.mocked()
        when:
            ISEConnector connector = connectorFactory.getConnector(connectorType, MessageTransferPropsTestData.sample1())
        then:
            Exception e = thrown()
            e instanceof ConnectorFactoryException
        where:
            connectorType = Data.ConnectorType.err()
    }

    static class Data {

        static ConnectorFactory mocked() {
            return new ConnectorFactory(ConnectorDefinitions.sample3())
        }

        static class ConnectorType {
            static String sample1() { MessageTransferProps.CONNECTOR_NAME }
            static String sample2() { "QUEUE_PURGE" }
            static String sample3() { "MESSAGE WRITE" }
            static String err() { "THIS DOEN'T EXIST" }
        }

        static class ConnectorDefinitions {
            static String empty() { [] }

            static List<ConnectorDefinition> sample1() {
                return [ConnectorDefinitionTest.Data.sample1()]
            }

            static List<ConnectorDefinition> sample2() {
                return [ConnectorDefinitionTest.Data.sample1(),
                 ConnectorDefinitionTest.Data.sample2()]
            }

            static List<ConnectorDefinition> sample3() {
                return [ConnectorDefinitionTest.Data.sample1(),
                        ConnectorDefinitionTest.Data.sample2(),
                        ConnectorDefinitionTest.Data.sample3()]
            }
        }
    }

}
