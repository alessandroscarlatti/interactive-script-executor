package com.scarlatti.ise.app.scriptBuilder.model

import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransfer
import com.scarlatti.ise.app.palette.rabbitmq.connectors.MessageTransferPropsTestData
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Monday, 1/15/2018
 */
class ISEConnectorTest extends Specification {
    static class Data {
        static ISEConnector sample1() {
            return new MessageTransfer(MessageTransferPropsTestData.sample1())
        }

        static ISEConnector sample2() {
            return new MessageTransfer(MessageTransferPropsTestData.sample2())
        }

        static ISEConnector sample3() {
            return new MessageTransfer(MessageTransferPropsTestData.sample3())
        }
    }
}
