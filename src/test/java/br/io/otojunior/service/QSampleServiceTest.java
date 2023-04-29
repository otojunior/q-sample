/**
 * 
 */
package br.io.otojunior.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServerRequest;

/**
 * @author S014562316
 *
 */
@QuarkusTest
class QSampleServiceTest {
	QSampleService service;

	@BeforeEach
	void setup() {
		var headers = mock(MultiMap.class);
		var request = mock(HttpServerRequest.class);
		this.service = spy(QSampleService.class);
		when(headers.get("x-teste")).thenReturn("teste123");
		when(request.headers()).thenReturn(headers);
		service.request = request;
	}
	
	/**
	 * Test method for {@link br.io.otojunior.service.QSampleService#getXTesteHeader()}.
	 */
	@Test
	void testGetXTesteHeader() {
		assertEquals("teste123", service.getXTesteHeader());
	}
}
