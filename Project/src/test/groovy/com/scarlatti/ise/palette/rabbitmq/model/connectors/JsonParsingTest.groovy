package com.scarlatti.ise.palette.rabbitmq.model.connectors

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.scriptBuilder.model.Connector
import com.scarlatti.ise.scriptBuilder.model.json.ConnectorProps
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
    "parse MessageTransfer from JSON #json"(String json, MessageTransferProps messageTransfer) {
        when:
            ConnectorProps connector = new ObjectMapper().readValue(json, ConnectorProps.class)
        then:
            connector != null
            connector.class == MessageTransferProps
            connector == messageTransfer
        where:
            json                                          | messageTransfer
            MessageTransferPropsTestData.JSON.sample1()   | MessageTransferPropsTestData.sample1()
            MessageTransferPropsTestData.JSON.sample2()   | MessageTransferPropsTestData.sample2()
            MessageTransferPropsTestData.JSON.sample3()   | MessageTransferPropsTestData.sample3()
    }
}
