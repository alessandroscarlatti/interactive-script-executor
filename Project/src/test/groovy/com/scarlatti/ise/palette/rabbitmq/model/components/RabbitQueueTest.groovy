package com.scarlatti.ise.palette.rabbitmq.model.components

import com.scarlatti.ise.palette.rabbitmq.components.RabbitQueue
import com.scarlatti.ise.palette.rabbitmq.model.RabbitQueueProps
import com.scarlatti.ise.scriptBuilder.model.ComponentDefinition
import com.scarlatti.ise.scriptBuilder.model.ISEComponent
import com.scarlatti.ise.scriptBuilder.model.json.ComponentProps

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class RabbitQueueTest {
    static class Data {
        static RabbitQueue empty() {
            return new RabbitQueue(RabbitQueuePropsTest.Data.empty())
        }

        static RabbitQueue sample1() {
            return new RabbitQueue(RabbitQueuePropsTest.Data.sample1())
        }

        static RabbitQueue sample2() {
            return new RabbitQueue(RabbitQueuePropsTest.Data.sample2())
        }

        static RabbitQueue sample3() {
            return new RabbitQueue(RabbitQueuePropsTest.Data.sample3())
        }

        class DefaultComponentDefinition {
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
                return new RabbitQueue.DefaultComponentDefinition()
            }

            static ComponentDefinition sample2() {
                return new ComponentDefinition() {
                    @Override
                    ISEComponent provideComponent(ComponentProps props) {
                        new RabbitQueue(RabbitQueuePropsTest.Data.sample2())
                    }

                    @Override
                    String forType() {
                        return RabbitQueueProps.COMPONENT_NAME
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
                        return RabbitQueueProps.COMPONENT_NAME
                    }
                }
            }
        }
    }
}
