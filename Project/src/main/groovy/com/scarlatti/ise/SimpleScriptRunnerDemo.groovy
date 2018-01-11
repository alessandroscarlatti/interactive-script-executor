package com.scarlatti.ise

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Wednesday, 1/10/2018
 *
 * This demo script is intended simply to demonstrate the execution
 * of the user provided script, including injection of the closure parameters.
 */
@Component
class SimpleScriptRunnerDemo implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

    @Override
    void run(String... args) throws Exception {
        // take the string and create a closure out of it...
        String script = userProvidedScript()

        log.info("user provided script: ${script}")

        def runnableScript= makeRunnableScript(script)
        int sum = runnableScript.run(2, 4)

        log.info("ran user script and got: ${sum}")
    }

    /**
     * I will provide this for now, but eventually the user would do this.
     *
     * @return string representing the script that the user would provide.
     */
    String userProvidedScript() {
        return """
            // now I can easily add my own code in this Groovy String!
            return a + b
        """
    }

    /**
     * Wrap the given script in the expected closure params.
     *
     * @param script the script to wrap in the closure.
     * @return the string of the closure, ready to be compiled and run
     */
    def makeRunnableScript(String script) {
        def parent = getClass().classLoader
        def loader = new GroovyClassLoader(parent)
        return loader.parseClass("""
            def run (int a, int b) {
                ${script}
            }
        """).newInstance()
    }


}
