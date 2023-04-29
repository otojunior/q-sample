package br.io.otojunior.controller;

import br.io.otojunior.service.QSampleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class QSampleController {
	@Inject
	QSampleService service;
	
    /**
     * 
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.getXTesteHeader();
    }
}