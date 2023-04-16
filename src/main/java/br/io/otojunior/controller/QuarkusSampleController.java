package br.io.otojunior.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/hello")
public class QuarkusSampleController {
    /**
     * 
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni
    		.createFrom()
    		.item("Hello from RESTEasy Reactive");
    }
}