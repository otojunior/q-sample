/**
 * 
 */
package br.io.otojunior.service;

import io.vertx.core.http.HttpServerRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Context;

/**
 * @author S014562316
 *
 */
@ApplicationScoped
public class QSampleService {
	@Context
	HttpServerRequest request;
	
	public String getXTesteHeader() {
		return request.headers().get("x-teste");
	}
}
