package com.scarlatti.ise.rabbitmq.model.connectors

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.scriptBuilder.model.Connector
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class JsonParsingTest extends Specification {

    @Unroll
    "parse correct subclass from JSON #json"(String json, MessageTransfer messageTransfer) {
        when:
            Connector connector = new ObjectMapper().readValue(json, Connector.class)
        then:
            connector != null
            connector.class == MessageTransfer
            connector == messageTransfer
        where:
            json                                    | messageTransfer
            MessageTransferTestData.jsonSample1()   | MessageTransferTestData.sample1()
            MessageTransferTestData.jsonSample2()   | MessageTransferTestData.sample2()
            MessageTransferTestData.jsonSample3()   | MessageTransferTestData.sample3()
    }
}
