/**
 * 
 */
package br.io.otojunior.service;

import io.vertx.mutiny.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * @author S014562316
 *
 */
@ApplicationScoped
public class QSampleService {
	@Inject
	RoutingContext context;
	
	public String getXTesteHeader() {
		return context.request().headers().get("x-teste");
	}
}
