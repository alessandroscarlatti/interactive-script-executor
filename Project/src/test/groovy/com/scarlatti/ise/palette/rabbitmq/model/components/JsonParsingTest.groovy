package com.scarlatti.ise.palette.rabbitmq.model.components

import com.fasterxml.jackson.databind.ObjectMapper
import com.scarlatti.ise.scriptBuilder.model.json.ComponentProps
import spock.lang.Specification
import spock.lang.Unroll

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class JsonParsingTest extends Specification {

    @Unroll
    "parse RabbitQueue from JSON #json"(String json, RabbitQueueProps rabbitQueue) {
        when:
            ComponentProps component = new ObjectMapper().readValue(json, ComponentProps.class)
        then:
            component != null
            component.class == RabbitQueueProps
            component == rabbitQueue
        where:
            json                                    | rabbitQueue
            RabbitQueuePropsTestData.JSON.sample1() | RabbitQueuePropsTestData.sample1()
            RabbitQueuePropsTestData.JSON.sample2() | RabbitQueuePropsTestData.sample2()
            RabbitQueuePropsTestData.JSON.sample3() | RabbitQueuePropsTestData.sample3()
    }
}
