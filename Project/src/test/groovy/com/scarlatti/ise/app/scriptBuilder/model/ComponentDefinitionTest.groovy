package com.scarlatti.ise.app.scriptBuilder.model

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueue
import com.scarlatti.ise.app.palette.rabbitmq.model.components.RabbitQueuePropsTest
import com.scarlatti.ise.app.scriptBuilder.ComponentFactoryTest
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ComponentDefinitionTest extends Specification {
    static class Data {
        static ComponentDefinition nil() {
            return new ComponentDefinition() {
                @Override
                ISEComponent provideComponent(ComponentProps props) {
                    return null
                }

                @Override
                String forType() {
                    return null
                }
            }
        }

        static ComponentDefinition sample1() {
            return new ComponentDefinition() {
                @Override
                ISEComponent provideComponent(ComponentProps props) {
                    new RabbitQueue(RabbitQueuePropsTest.Data.sample1())
                }

                @Override
                String forType() {
                    return ComponentFactoryTest.Data.ComponentType.sample1()
                }
            }
        }

        static ComponentDefinition sample2() {
            return new ComponentDefinition() {
                @Override
                ISEComponent provideComponent(ComponentProps props) {
                    new RabbitQueue(RabbitQueuePropsTest.Data.sample2())
                }

                @Override
                String forType() {
                    return ComponentFactoryTest.Data.ComponentType.sample2()
                }
            }
        }

        static ComponentDefinition sample3() {
            return new ComponentDefinition() {
                @Override
                ISEComponent provideComponent(ComponentProps props) {
                    new RabbitQueue(RabbitQueuePropsTest.Data.sample3())
                }

                @Override
                String forType() {
                    return ComponentFactoryTest.Data.ComponentType.sample3()
                }
            }
        }
    }
}
