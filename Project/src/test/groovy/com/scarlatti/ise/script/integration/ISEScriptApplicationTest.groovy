package com.scarlatti.ise.script.integration

import com.scarlatti.ise.script.ISEScriptApplication
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [ISEScriptApplication])
class ISEScriptApplicationTest extends Specification {

	@Test
	"context can load"() {
		when:
			println "loaded context."
		then:
			notThrown(Exception)
	}

}
