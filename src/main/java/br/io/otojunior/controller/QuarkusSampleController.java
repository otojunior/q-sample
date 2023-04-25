package br.io.otojunior.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestPath;

import io.smallrye.common.annotation.Blocking;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/")
public class QuarkusSampleController {
    /**
     * 
     * @return
     */
    @GET
    @Path("/{n}")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public String hello(@RestPath final int n) {
    	try {
    		log.info("INICIO");
    		Thread.sleep(n);
    		log.info("FIM");
		}
    	catch (InterruptedException e) {
    		log.error(e.getMessage());
		}
    	
        return "Processado: " + n + System.lineSeparator();
    }
}