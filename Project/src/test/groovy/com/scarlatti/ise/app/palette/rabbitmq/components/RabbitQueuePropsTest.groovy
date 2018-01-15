package com.scarlatti.ise.app.palette.rabbitmq.components

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.app.scriptBuilder.model.ComponentPropsTestData
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class RabbitQueuePropsTest extends Specification {

    @Unroll
    "parse RabbitQueue from JSON #json"(String json, RabbitQueueProps rabbitQueue) {
        when:
            ComponentProps component = new ObjectMapper().readValue(json, ComponentProps.class)
        then:
            component != null
            component.class == RabbitQueueProps
            component == rabbitQueue
        where:
            json                                     | rabbitQueue
            Data.JSON.sample1() | Data.sample1()
            Data.JSON.sample2() | Data.sample2()
            Data.JSON.sample3() | Data.sample3()
    }

    static class Data {

        static RabbitQueueProps nil() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.nil(),
                    address: Address.nil(),
                    vhost: Vhost.nil(),
                    queue: Queue.nil(),
                    username: Username.nil(),
                    password: Password.nil()
            )
        }

        static RabbitQueueProps empty() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.empty(),
                    address: Address.empty(),
                    vhost: Vhost.empty(),
                    queue: Queue.empty(),
                    username: Username.empty(),
                    password: Password.empty()
            )
        }

        static RabbitQueueProps sample1() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.sample1(),
                    address: Address.sample1(),
                    vhost: Vhost.sample1(),
                    queue: Queue.sample1(),
                    username: Username.sample1(),
                    password: Password.sample1()
            )
        }

        static RabbitQueueProps sample2() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.sample2(),
                    address: Address.sample2(),
                    vhost: Vhost.sample2(),
                    queue: Queue.sample2(),
                    username: Username.sample2(),
                    password: Password.sample2()
            )
        }

        static RabbitQueueProps sample3() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.sample3(),
                    address: Address.sample3(),
                    vhost: Vhost.sample3(),
                    queue: Queue.sample3(),
                    username: Username.sample3(),
                    password: Password.sample3()
            )
        }

        static RabbitQueueProps sample4() {
            return new RabbitQueueProps(
                    id: ComponentPropsTestData.ID.sample4(),
                    address: Address.sample4(),
                    vhost: Vhost.sample4(),
                    queue: Queue.sample4(),
                    username: Username.sample4(),
                    password: Password.sample4()
            )
        }

        static class JSON {
            static String nil() {
                return """null"""
            }

            static String defs() {
                return """
                {
                    "type": "RABBIT_QUEUE"
                }"""
            }

            static String empty() {
                return """
                {
                    "id": "${ComponentPropsTestData.ID.empty()}",
                    "type": "RABBIT_QUEUE",
                    "address": "${Address.empty()}",
                    "vhost": "${Vhost.empty()}",
                    "queue": "${Queue.empty()}",
                    "username": "${Username.empty()}",
                    "password": "${Password.empty()}"
                }"""
            }

            static String sample1() {
                return """
                {
                    "id": "${ComponentPropsTestData.ID.sample1()}",
                    "type": "RABBIT_QUEUE",
                    "address": "${Address.sample1()}",
                    "vhost": "${Vhost.sample1()}",
                    "queue": "${Queue.sample1()}",
                    "username": "${Username.sample1()}",
                    "password": "${Password.sample1()}"
                }"""
            }

            static String sample2() {
                return """
                {
                    "id": "${ComponentPropsTestData.ID.sample2()}",
                    "type": "RABBIT_QUEUE",
                    "address": "${Address.sample2()}",
                    "vhost": "${Vhost.sample2()}",
                    "queue": "${Queue.sample2()}",
                    "username": "${Username.sample2()}",
                    "password": "${Password.sample2()}"
                }"""
            }

            static String sample3() {
                return """
                {
                    "id": "${ComponentPropsTestData.ID.sample3()}",
                    "type": "RABBIT_QUEUE",
                    "address": "${Address.sample3()}",
                    "vhost": "${Vhost.sample3()}",
                    "queue": "${Queue.sample3()}",
                    "username": "${Username.sample3()}",
                    "password": "${Password.sample3()}"
                }"""
            }

            static String sample4() {
                return """
                {
                    "id": "${ComponentPropsTestData.ID.sample4()}",
                    "type": "RABBIT_QUEUE",
                    "address": "${Address.sample4()}",
                    "vhost": "${Vhost.sample4()}",
                    "queue": "${Queue.sample4()}",
                    "username": "${Username.sample4()}",
                    "password": "${Password.sample4()}"
                }"""
            }
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

            static String sample4() {
                return "you.know.us"
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

            static String sample4() {
                return "/cow"
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

            static String sample4() {
                return "snacks"
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

            static String sample4() {
                return "domenico@baroque.it"
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

            static String sample4() {
                return "passwordpassword"
            }
        }
    }


}
