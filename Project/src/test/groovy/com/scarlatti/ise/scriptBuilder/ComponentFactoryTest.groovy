package com.scarlatti.ise.scriptBuilder

import com.scarlatti.ise.palette.rabbitmq.model.components.RabbitQueueTest
import com.scarlatti.ise.scriptBuilder.model.ComponentDefinition
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ComponentFactoryTest extends Specification {


    static class Data {

        static class ComponentType {
            static String sample1() { "RABBIT_QUEUE" }
            static String sample2() { "FILE" }
            static String sample3() { "SERVER" }
        }

        static class ComponentDefinitions {
            static String empty() { [] }

            static List<ComponentDefinition> sample1() {
                [RabbitQueueTest.Data.DefaultComponentDefinition.sample1()]
            }

            static List<ComponentDefinition> sample2() {
                [RabbitQueueTest.Data.DefaultComponentDefinition.sample1(),
                 RabbitQueueTest.Data.DefaultComponentDefinition.sample2()]
            }

            static List<ComponentDefinition> sample3() {
                return [RabbitQueueTest.Data.DefaultComponentDefinition.sample1(),
                        RabbitQueueTest.Data.DefaultComponentDefinition.sample2(),
                        RabbitQueueTest.Data.DefaultComponentDefinition.sample2()]
            }
        }
    }

}
