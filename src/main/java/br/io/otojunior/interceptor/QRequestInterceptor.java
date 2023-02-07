/**
 * 
 */
package br.io.otojunior.interceptor;

import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * Interceptador de Request para logar o JSON que chega.
 * @author Oto Soares Coelho Junior
 * @since 06/02/2023
 */
@Slf4j
public class QRequestInterceptor {
    /**
     * 
     * @param request
     */
    @ServerRequestFilter
    public void asyncLog(HttpServerRequest request) {
        if (log.isDebugEnabled()) {
            final var requestUri = request.uri();
            final var requestBody = request.body();
            requestBody.onComplete(event -> log.debug("Request {}:\n{}",
                requestUri,
                event.result()
                    .toJsonObject()
                    .encodePrettily()));   
        }
    }
}
