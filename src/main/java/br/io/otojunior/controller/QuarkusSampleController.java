package br.io.otojunior.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.eclipse.microprofile.context.ManagedExecutor;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/hello")
public class QuarkusSampleController {
	@Inject
	ManagedExecutor executor;
	
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
    
    /**
     * 
     * @return
     */
    @GET
    @Path("/async-mutiny")
    @Produces(MediaType.TEXT_PLAIN)
    public String asyncMutiny() {
    	for (int i = 0; i < 10; i++) {
    		Uni.createFrom()
	    		.item(this::simularProcessamentoDemorado)
	    		.runSubscriptionOn(Infrastructure.getDefaultExecutor())
	    		.subscribe()
	    		.with(item -> {});
		}
    	log.debug("Thread principal: 1");
    	log.debug("Thread principal: 2");
    	log.debug("Thread principal: 3");
        
    	return "OP: Async com Mutiny";
    }
    
    /**
     * 
     * @return
     */
    @GET
    @Path("/async-executor")
    @Produces(MediaType.TEXT_PLAIN)
    public String asyncExecutor() {
    	for (int i = 0; i < 10; i++) {
    		executor.runAsync(() -> {
        		simularProcessamentoDemorado();
        	});
		}
    	
    	log.debug("Thread principal: 1");
    	log.debug("Thread principal: 2");
    	log.debug("Thread principal: 3");
    	
    	return "OP: Async com Executor";
    }
    
    /**
     * 
     * @param n
     * @throws InterruptedException 
     */
    private final Null simularProcessamentoDemorado() {
        try {
        	log.debug("INICIO - Processamento Demorado");
        	Thread.sleep(2000);
        	log.debug("FIM - Processamento Demorado");
        	return ObjectUtils.NULL;
    	}
        catch (InterruptedException e) {
        	log.error(e.getMessage());
        	throw new RuntimeException(e);
    	}
    }
}