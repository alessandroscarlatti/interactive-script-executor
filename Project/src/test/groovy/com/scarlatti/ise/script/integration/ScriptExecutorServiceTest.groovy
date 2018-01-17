package com.scarlatti.ise.script.integration

import com.scarlatti.ise.app.ISEApplication
import com.scarlatti.ise.app.scriptBuilder.model.ScriptPropsTestData
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutionResult
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutionResultTest
import com.scarlatti.ise.app.scriptExecutor.ScriptExecutorService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [ISEApplication])
class ScriptExecutorServiceTest extends Specification {

	@Autowired ScriptExecutorService scriptExecutorService

	@Test
	"load and execute script"() {
		when:
			String json = Data.JSON.sample1()
			ScriptExecutionResult result = scriptExecutorService.execute(json)
		then:
			notThrown(Exception)
			result == ScriptExecutionResultTest.Data.sample1()
	}

	static class Data {
		static class JSON {
			static String sample1() {
				return ScriptPropsTestData.JSON.sample2()
			}
		}
	}

}
