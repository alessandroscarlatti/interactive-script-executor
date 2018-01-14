package com.scarlatti.ise.integration

import com.scarlatti.ise.app.ISEApplication
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [ISEApplication])
class ISEApplicationTest extends Specification {

	@Test
	"context can load"() {
		when:
			println "loaded context."
		then:
			notThrown(Exception)
	}

}
