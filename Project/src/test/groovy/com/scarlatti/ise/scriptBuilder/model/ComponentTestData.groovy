package com.scarlatti.ise.scriptBuilder.model

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class ComponentTestData {

    static class ID {
        static String nil() {
            return null
        }

        static String empty() {
            return ""
        }

        static String sample1() {
            return "Queue #1"
        }

        static String sample2() {
            return "Queue #2"
        }

        static String sample3() {
            return "Queue #3"
        }
    }
}
