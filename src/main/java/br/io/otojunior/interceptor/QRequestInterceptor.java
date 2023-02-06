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
        request.body().onComplete(event -> log.debug(event.result().toString()));   
    }
}
