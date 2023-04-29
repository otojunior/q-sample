/**
 * 
 */
package br.io.otojunior.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.vertx.mutiny.ext.web.RoutingContext;
import jakarta.inject.Inject;

/**
 * @author S014562316
 *
 */
@QuarkusTest
class QSampleServiceTest {
	@InjectMock
	RoutingContext context;
	
	@Inject
	QSampleService service;
	
	/**
	 * Test method for {@link br.io.otojunior.service.QSampleService#getXTesteHeader()}.
	 */
	@Test
	void testGetXTesteHeader() {
		assertNotNull(service);
	}
}
