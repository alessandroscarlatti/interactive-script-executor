package com.scarlatti.ise.app.scriptBuilder

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueue
import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueueProps
import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueuePropsTest
import com.scarlatti.ise.app.scriptBuilder.exceptions.ComponentFactoryException
import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinition
import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinitionTest
import com.scarlatti.ise.app.scriptBuilder.model.ISEComponent
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ComponentFactoryTest extends Specification {

    @Unroll
    "return correct component for component type: #componentType"(String componentType) {
        setup:
            ComponentFactory componentFactory = Data.mocked()
        when:
            ISEComponent component = componentFactory.getComponent(componentType, RabbitQueuePropsTest.Data.sample1())
        then:
            component != null
            component instanceof RabbitQueue
        where:
            componentType = Data.ComponentType.sample1()
    }

    @Unroll
    "exception thrown for unrecognized component type: #componentType"(String componentType) {
        setup:
            ComponentFactory componentFactory = Data.mocked()
        when:
            ISEComponent component = componentFactory.getComponent(componentType, RabbitQueuePropsTest.Data.sample1())
        then:
            Exception e = thrown()
            e instanceof ComponentFactoryException
        where:
            componentType = Data.ComponentType.err()
    }

    static class Data {

        static ComponentFactory mocked() {
            return new ComponentFactory(ComponentDefinitions.sample3())
        }

        static class ComponentType {
            static String sample1() { RabbitQueueProps.COMPONENT_NAME }
            static String sample2() { "FILE" }
            static String sample3() { "SERVER" }
            static String err() { "THIS DOEN'T EXIST " }
        }

        static class ComponentDefinitions {
            static String empty() { [] }

            static List<ComponentDefinition> sample1() {
                [ComponentDefinitionTest.Data.sample1()]
            }

            static List<ComponentDefinition> sample2() {
                [ComponentDefinitionTest.Data.sample1(),
                 ComponentDefinitionTest.Data.sample2()]
            }

            static List<ComponentDefinition> sample3() {
                return [ComponentDefinitionTest.Data.sample1(),
                        ComponentDefinitionTest.Data.sample2(),
                        ComponentDefinitionTest.Data.sample3()]
            }
        }
    }

}
