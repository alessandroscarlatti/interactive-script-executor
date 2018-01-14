package com.scarlatti.ise.app.integration

import com.scarlatti.ise.app.ISEApplication
import com.scarlatti.ise.app.scriptBuilder.model.ScriptPropsTestData
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutionResult
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutorService
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutorServiceTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [ISEApplication])
class ISEApplicationTest extends Specification {

	@Autowired
	ScriptExecutorService scriptExecutorService

	@Test
	"context can load"() {
		when:
			println "loaded context."
		then:
			notThrown(Exception)
	}

	@Test
	"starts and runs the script application context"() {
		when:
			ScriptExecutionResult result = scriptExecutorService.execute(ScriptPropsTestData.sample1())
		then:
			result == new ScriptExecutionResult(0)
	}

}
