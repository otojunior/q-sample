package br.io.otojunior.sql;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.pgclient.PgPool;
import lombok.extern.slf4j.Slf4j;

/**
 * SQL SELECT usando o PgPool / Mutiny.
 * @author Oto Soares Coelho Junior
 * @since 11/04/2023
 */
@Slf4j
@ApplicationScoped
public class SqlSelectMutiny {
	@Inject
	PgPool client;

	/**
	 * Evento onStart
	 * @param ev {@link StartupEvent}
	 */
	void onStart(@Observes StartupEvent ev) {
        client
        	.preparedQuery("SELECT * FROM TESTE")
        	.execute()
        	.subscribe()
        	.with(
    			onItemCallback -> {
    				onItemCallback.forEach(row -> {
    					log.info("Row [id={},nome={}]",
	    					row.getInteger("id"),
	    					row.getString("nome"));
    				});
    			},
    			onFailureCallback -> {
    				log.error(
						"Erro na integracao com o banco de dados: {} ",
						onFailureCallback.getMessage());
    			});
	}
}
