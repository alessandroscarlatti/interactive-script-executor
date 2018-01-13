package com.scarlatti.ise.scriptBuilder.model

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class ConnectorTestData {

    static class Id {
        static String nullId() {
            return null
        }

        static String emptyId() {
            return ""
        }

        static String sampleId1() {
            return "connector1"
        }

        static String sampleId2() {
            return "connector2"
        }

        static String sampleId3() {
            return "connector3"
        }
    }
}
