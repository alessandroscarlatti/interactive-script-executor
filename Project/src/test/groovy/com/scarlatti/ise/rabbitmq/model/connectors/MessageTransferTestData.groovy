package com.scarlatti.ise.rabbitmq.model.connectors

import com.scarlatti.ise.scriptBuilder.model.ConnectorTestData

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class MessageTransferTestData {

    static MessageTransfer nil() {
        return new MessageTransfer(
                id: ConnectorTestData.Id.nil(),
                from:  From.nil(),
                to:  To.nil()
        )
    }

    static MessageTransfer empty() {
        return new MessageTransfer(
                id: ConnectorTestData.Id.empty(),
                from:  From.empty(),
                to:  To.empty()
        )
    }

    static MessageTransfer sample1() {
        return new MessageTransfer(
                id: ConnectorTestData.Id.sample1(),
                from:  From.sample1(),
                to:  To.sample1()
        )
    }

    static MessageTransfer sample2() {
        return new MessageTransfer(
                id: ConnectorTestData.Id.sample2(),
                from:  From.sample2(),
                to:  To.sample2()
        )
    }

    static MessageTransfer sample3() {
        return new MessageTransfer(
                id: ConnectorTestData.Id.sample3(),
                from:  From.sample3(),
                to:  To.sample3()
        )
    }

    static String jsonNil() {
        return """"""
    }

    static String jsonEmpty() {
        return """{}"""
    }

    static String jsonSample1() {
        return """
        {
            "id": "${ConnectorTestData.Id.sample1()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample1()}",
            "to": "${To.sample1()}"
        }"""
    }

    static String jsonSample2() {
        return """
        {
            "id": "${ConnectorTestData.Id.sample2()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample2()}",
            "to": "${To.sample2()}"
        }"""
    }

    static String jsonSample3() {
        return """
        {
            "id": "${ConnectorTestData.Id.sample3()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample3()}",
            "to": "${To.sample3()}"
        }"""
    }

    static class From {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "Queue #1"
        }

        static String sample2() {
            return "Queue #2"
        }

        static String sample3() {
            return "Queue #3"
        }
    }

    static class To {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "Queue #5"
        }

        static String sample2() {
            return "Queue #6"
        }

        static String sample3() {
            return "Queue #7"
        }
    }

}
