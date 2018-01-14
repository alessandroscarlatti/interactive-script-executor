package com.scarlatti.ise.app.palette.rabbitmq.model.connectors

import com.scarlatti.ise.app.palette.rabbitmq.model.MessageTransferProps
import com.scarlatti.ise.app.scriptBuilder.model.ConnectorPropsTestData

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class MessageTransferPropsTestData {

    static MessageTransferProps nil() {
        return new MessageTransferProps(
                id: ConnectorPropsTestData.Id.nil(),
                from:  From.nil(),
                to:  To.nil(),
                howMany: HowMany.nil()
        )
    }

    static MessageTransferProps empty() {
        return new MessageTransferProps(
                id: ConnectorPropsTestData.Id.empty(),
                from:  From.empty(),
                to:  To.empty(),
                howMany: HowMany.empty()
        )
    }

    static MessageTransferProps sample1() {
        return new MessageTransferProps(
                id: ConnectorPropsTestData.Id.sample1(),
                from:  From.sample1(),
                to:  To.sample1(),
                howMany: HowMany.sample1()
        )
    }

    static MessageTransferProps sample2() {
        return new MessageTransferProps(
                id: ConnectorPropsTestData.Id.sample2(),
                from:  From.sample2(),
                to:  To.sample2(),
                howMany: HowMany.sample2()
        )
    }

    static MessageTransferProps sample3() {
        return new MessageTransferProps(
                id: ConnectorPropsTestData.Id.sample3(),
                from:  From.sample3(),
                to:  To.sample3(),
                howMany: HowMany.sample3()
        )
    }

    static class JSON {
        static String nil() {
            return """"""
        }

        static String empty() {
            return """{}"""
        }

        static String sample1() {
            return """
        {
            "id": "${ConnectorPropsTestData.Id.sample1()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample1()}",
            "to": "${To.sample1()}",
            "howMany": "${HowMany.sample1()}"
        }"""
        }

        static String sample2() {
            return """
        {
            "id": "${ConnectorPropsTestData.Id.sample2()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample2()}",
            "to": "${To.sample2()}",
            "howMany": "${HowMany.sample2()}"
        }"""
        }

        static String sample3() {
            return """
        {
            "id": "${ConnectorPropsTestData.Id.sample3()}",
            "type": "RABBIT_MESSAGE_TRANSFER",
            "from": "${From.sample3()}",
            "to": "${To.sample3()}",
            "howMany": "${HowMany.sample3()}"
        }"""
        }
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

    static class HowMany {
        static Integer nil() {
            return null
        }

        static Integer negative() {
            return -5
        }

        static Integer empty() {
            return 0
        }

        static Integer sample1() {
            return 14
        }

        static Integer sample2() {
            return 34
        }

        static Integer sample3() {
            return 57
        }
    }

}
