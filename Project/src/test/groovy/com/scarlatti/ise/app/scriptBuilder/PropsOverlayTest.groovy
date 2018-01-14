package com.scarlatti.ise.app.scriptBuilder

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.junit.Test
import spock.lang.Ignore
import spock.lang.Specification

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
class PropsOverlayTest extends Specification {


    def mergeMaps(def lhs, def rhs) {
        rhs.each { k, v ->
            lhs[k] = lhs[k] in Map ? mergeMaps(lhs[k], v) : v
        }
        return lhs
    }

    def mergeObjects(Overlayable lhs, Overlayable rhs) {
        rhs.provideProps().each { k, v ->
            def lhsProps = lhs.provideProps()
            if (lhsProps[k] instanceof Overlayable && v instanceof Overlayable) {
                lhs."$k" = mergeObjects((Overlayable)lhsProps[k], v)
            } else if (v != null) {
                lhs."$k" = v
            }
        }
        return lhs
    }

    @Test
    "overlay simple properties"() {
        setup:
        def defs = [
                propA: "defA",
                propB: "defB"
        ]

        def prov = []

        def exp = [
                propA: "defA",
                propB: "defB"
        ]
        when:
            def props = defs + prov
        then:
            props == exp
    }

    @Test
    "overlay nested properties"() {
        setup:
            def defs = [
                    propA: "defA",
                    propB: [
                            propC: "defC"
                    ]
            ]

            def prov = []

            def exp = [
                    propA: "defA",
                    propB: [
                            propC: "defC"
                    ]
            ]
        when:
            def props = defs + prov
        then:
            props == exp
    }

    @Test
    "overlay properties with top level properties"() {
        setup:
            def defs = [
                    propA: "defA",
                    propB: [
                            propC: "defC"
                    ]
            ]

            def prov = [
                    propA: "newA"
            ]

            def exp = [
                    propA: "newA",
                    propB: [
                            propC: "defC"
                    ]
            ]
        when:
            def props = defs + prov
        then:
            props == exp
    }

    @Test
    "can overlay properties with second level properties"() {
        setup:
            def defs = [
                    propA: "defA",
                    propB: [
                            propC: "defC",
                            propD: "defD"
                    ]
            ]

            def prov = [
                    propB: [
                            propC: "newC"
                    ]
            ]

            def exp = [
                    propA: "defA",
                    propB: [
                            propC: "newC",
                            propD: "defD"
                    ]
            ]
        when:
            def props = mergeMaps(defs, prov)
        then:
            props == exp
    }

    @Test
    @Ignore
    "can overlay properties on object with second level properties"() {
        setup:
            def defs = new Penguin(
                    name:  "defPenguin",
                    age:  1,
                    friend: new Puffin(
                            name:  "defPuffin",
                            age:  2
                    )
            )

            def prov = new Penguin(
                    name:  "anotherPenguin",
                    friend: new Puffin(
                            age:  365
                    )
            )
            def exp = new Penguin(
                    name:  "anotherPenguin",
                    age:  1,
                    friend: new Puffin(
                            name:  "defPuffin",
                            age:  365
                    )
            )
        when:
            def props = defs.overlay(prov)
        then:
            props == exp
    }

    trait Overlayable {
        Overlayable overlay(Overlayable obj) {
            obj.provideProps().each { k, v ->
                def lhsProps = provideProps()
                if (lhsProps[k] instanceof Overlayable && v instanceof Overlayable) {
                    this."$k" = ((Overlayable)lhsProps[k]).overlay(v)
                } else if (v != null) {
                    this."$k" = v
                }
            }
            return this
        }

        abstract Map<String, Object> provideProps()
    }

    @ToString
    @EqualsAndHashCode
    static class Penguin implements Overlayable {
        String name
        Integer age
        Puffin friend

        @Override
        Map<String, Object> provideProps() {
            this.properties.findAll { it.key != "class"}
        }
    }

    @ToString
    @EqualsAndHashCode
    static class Puffin implements Overlayable {
        String name
        Integer age

        @Override
        Map<String, Object> provideProps() {
            this.properties.findAll { it.key != "class"}
        }
    }
}
