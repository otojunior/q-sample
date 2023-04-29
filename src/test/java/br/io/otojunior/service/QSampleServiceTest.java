/**
 * 
 */
package br.io.otojunior.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.vertx.core.http.HttpServerRequest;
import jakarta.inject.Inject;

/**
 * @author S014562316
 *
 */
@QuarkusTest
class QSampleServiceTest {
	@InjectMock
	HttpServerRequest request;
	
	@Inject
	QSampleService service;

	/**
	 * Test method for {@link br.io.otojunior.service.QSampleService#getXTesteHeader()}.
	 */
	@Test
	void testRequest() {
		assertNotNull(request);
	}
	
	/**
	 * Test method for {@link br.io.otojunior.service.QSampleService#getXTesteHeader()}.
	 */
	@Test
	void testGetXTesteHeader() {
		assertNotNull(service);
	}
}
