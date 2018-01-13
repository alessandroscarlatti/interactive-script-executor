package com.scarlatti.ise.scriptBuilder.model

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
class ScriptTestData {

    static class Id {
        static String nullID() {
            return null
        }

        static String emptyID() {
            return ""
        }

        static String sampleID_1() {
            return "rabbitQueueScript"
        }

        static String sampleID_2() {
            return "databaseScript"
        }

        static String sampleId3() {
            return "restScript"
        }
    }
}
