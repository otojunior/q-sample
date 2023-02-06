package br.io.otojunior.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/hello")
public class QuarkusSampleController {
    /**
     * 
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(Dto dto) {
        log.debug("dto.id: {}", dto.id);
        log.debug("dto.nome: {}", dto.nome);
        return "Hello from RESTEasy Reactive";
    }
    
    public static class Dto {
        public Integer id;
        public String nome;
    }
}