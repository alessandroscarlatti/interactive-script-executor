package com.scarlatti.ise.scriptExecutor;

import com.scarlatti.ise.scriptBuilder.ScriptBuilderService;
import com.scarlatti.ise.scriptBuilder.model.json.ComponentProps;
import com.scarlatti.ise.scriptBuilder.model.json.ScriptProps;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 * <p>
 * The ScriptExecutorService will take in either a json ScriptProps
 * or a POJO ScriptProps and will execute the script.
 */
public class ScriptExecutorService {

    private ScriptBuilderService scriptBuilderService;

    public ScriptExecutorService(ScriptBuilderService scriptBuilderService) {
        this.scriptBuilderService = scriptBuilderService;
    }

    public ScriptExecutionResult execute(String scriptJSON) {
        ScriptProps scriptProps = scriptBuilderService.buildScriptProps(scriptJSON);
        return execute(scriptProps);
    }

    /**
     * The ScriptExecutorService should:
     * - inspect the scriptProps to find and execute each of the Creations.
     * - inspect the scriptProps to find and execute each of the Performances.
     *
     * @param scriptProps the scriptProps to inspect and execute
     * @return the result of the execution
     */
    public ScriptExecutionResult execute(ScriptProps scriptProps) {

        for (ComponentProps component : scriptProps.getComponents()) {

        }

        return new ScriptExecutionResult(0);
    }
}
