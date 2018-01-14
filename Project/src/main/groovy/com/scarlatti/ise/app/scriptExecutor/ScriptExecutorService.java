package com.scarlatti.ise.app.scriptExecutor;

import com.scarlatti.ise.app.scriptBuilder.ScriptBuilderService;
import com.scarlatti.ise.app.scriptBuilder.model.ISEScript;
import com.scarlatti.ise.app.scriptBuilder.model.json.ScriptProps;
import com.scarlatti.ise.app.scriptExecutor.model.ISEScriptContext;

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
        ISEScript script = scriptBuilderService.buildScript(scriptJSON);
        return execute(script);
    }


    public ScriptExecutionResult execute(ScriptProps scriptProps) {
        ISEScript script = scriptBuilderService.buildScript(scriptProps);
        return execute(script);
    }

    /**
     * The ScriptExecutorService should:
     * - inspect the script to find and execute each of the Creations.
     * - inspect the script to find and execute each of the Performances.
     *
     * @param script the script to execute
     * @return the result of the execution
     */
    public synchronized ScriptExecutionResult execute(ISEScript script) {

        // create the script context...
        return ISEScriptContext.run(context -> {
            script.getComponents().get(0).registerComponent(context);

            return new ScriptExecutionResult(0);
        });
    }
}