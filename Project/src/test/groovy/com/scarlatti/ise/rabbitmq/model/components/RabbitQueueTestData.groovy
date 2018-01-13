package com.scarlatti.ise.rabbitmq.model.components

import com.scarlatti.ise.scriptBuilder.model.ComponentTestData

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class RabbitQueueTestData {

    static RabbitQueue nil() {
        return new RabbitQueue(
                id: ComponentTestData.ID.nil(),
                address: Address.nil(),
                vhost: Vhost.nil(),
                queue: Queue.nil(),
                username: Username.nil(),
                password: Password.nil()
        )
    }

    static RabbitQueue empty() {
        return new RabbitQueue(
                id: ComponentTestData.ID.empty(),
                address: Address.empty(),
                vhost: Vhost.empty(),
                queue: Queue.empty(),
                username: Username.empty(),
                password: Password.empty()
        )
    }

    static RabbitQueue sample1() {
        return new RabbitQueue(
                id: ComponentTestData.ID.sample1(),
                address: Address.sample1(),
                vhost: Vhost.sample1(),
                queue: Queue.sample1(),
                username: Username.sample1(),
                password: Password.sample1()
        )
    }

    static RabbitQueue sample2() {
        return new RabbitQueue(
                id: ComponentTestData.ID.sample2(),
                address: Address.sample2(),
                vhost: Vhost.sample2(),
                queue: Queue.sample2(),
                username: Username.sample2(),
                password: Password.sample2()
        )
    }

    static RabbitQueue sample3() {
        return new RabbitQueue(
                id: ComponentTestData.ID.sample3(),
                address: Address.sample3(),
                vhost: Vhost.sample3(),
                queue: Queue.sample3(),
                username: Username.sample3(),
                password: Password.sample3()
        )
    }

    static class Address {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "localhost"
        }

        static String sample2() {
            return "google.com"
        }

        static String sample3() {
            return "what.scarlatti.io"
        }
    }

    static class Vhost {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "/"
        }

        static String sample2() {
            return "/puffins"
        }

        static String sample3() {
            return "/penguins"
        }
    }

    static class Queue {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "squawks"
        }

        static String sample2() {
            return "squeaks"
        }

        static String sample3() {
            return "orks"
        }
    }

    static class Username {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "ascarlatti"
        }

        static String sample2() {
            return "alessandroscarlatti"
        }

        static String sample3() {
            return "ascarlatti@alessandroscarlatti.what"
        }
    }

    static class Password {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "changeit"
        }

        static String sample2() {
            return "whatdoyouknow"
        }

        static String sample3() {
            return "thisisabadpassworddon'tuseit"
        }
    }
}
