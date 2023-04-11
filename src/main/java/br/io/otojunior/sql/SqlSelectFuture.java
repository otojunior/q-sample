package br.io.otojunior.sql;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;
import io.vertx.pgclient.PgPool;
import lombok.extern.slf4j.Slf4j;

/**
 * SQL SELECT usando o PgPool / Future.
 * @author Oto Soares Coelho Junior
 * @since 11/04/2023
 */
@Slf4j
@ApplicationScoped
public class SqlSelectFuture {
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
        	.onSuccess(handler -> {
				handler.forEach(row -> {
					log.info("Row [id={},nome={}]",
    					row.getInteger("id"),
    					row.getString("nome"));
				});
			})
        	.onFailure(handler -> {
        		log.error(
					"Erro na integracao com o banco de dados: {} ",
					handler.getMessage());
        	});
	}
}
