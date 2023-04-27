package br.io.otojunior.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/")
public class QuarkusSampleController {
    /**
     * 
     * @return
     */
    @GET
    @Path("/sentry")
    public String logerror() {
    	log.error("Teste Erro via SLF4J");
        throw new RuntimeException("Teste Erro via RuntimeException");
    }
}