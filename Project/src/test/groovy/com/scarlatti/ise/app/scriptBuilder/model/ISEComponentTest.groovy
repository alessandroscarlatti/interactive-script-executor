package com.scarlatti.ise.app.scriptBuilder.model

import com.scarlatti.ise.app.palette.rabbitmq.model.components.RabbitQueueTest
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class ISEComponentTest extends Specification {
    static class Data {
        static ISEComponent sample1() {
            return RabbitQueueTest.Data.sample1()
        }

        static ISEComponent sample2() {
            return RabbitQueueTest.Data.sample2()
        }

        static ISEComponent sample3() {
            return RabbitQueueTest.Data.sample3()
        }
    }
}
