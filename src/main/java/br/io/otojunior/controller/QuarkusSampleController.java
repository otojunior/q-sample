package br.io.otojunior.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tinylog.Logger;

@Path("/hello")
public class QuarkusSampleController {
    /**
     * 
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	Logger.error("Mensagem ERRO de exemplo");
        Logger.warn("Mensagem AVISO de exemplo");
        Logger.info("Mensagem INFO de exemplo");
        Logger.debug("Mensagem DEBUG de exemplo");
        Logger.trace("Mensagem TRACE de exemplo");

        return "Hello from RESTEasy Reactive";
    }
}