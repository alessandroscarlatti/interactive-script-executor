package com.scarlatti.ise.app.palette.rabbitmq.components
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

        static RabbitQueue sample4() {
            return new RabbitQueue(RabbitQueuePropsTest.Data.sample4())
        }
    }
}
