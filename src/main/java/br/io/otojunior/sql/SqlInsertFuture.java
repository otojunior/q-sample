package br.io.otojunior.sql;

import static java.util.UUID.randomUUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.CompositeFuture;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * SQL INSERT usando o PgPool / Future.
 * @author Oto Soares Coelho Junior
 * @since 11/04/2023
 */
@Slf4j
@ApplicationScoped
public class SqlInsertFuture {
	private static final String INSERT = "INSERT INTO TESTE VALUES ($1, $2)";
	
	@Inject
	PgPool client;

	/**
	 * Evento onStart
	 * @param ev {@link StartupEvent}
	 */
	void onStart(@Observes StartupEvent ev) {
		client.withTransaction(conn -> {
    		var insert1 = conn
				.preparedQuery(INSERT)
				.execute(Tuple.of(-3, randomUUID().toString()));
    		var insert2 = conn
				.preparedQuery(INSERT)
				.execute(Tuple.of(-4, randomUUID().toString()));
    		return CompositeFuture
				.join(insert1, insert2)
				.onSuccess(handler -> log.info("(dentro) Inserido Itens"))
				.onFailure(handler -> log.info("(dentro) Erro de Inserts"));
    		})
		.onSuccess(handler -> log.info("(fora) Inserido Itens"))
		.onFailure(handler -> log.info("(fora) Erro de Inserts"));
	}
}
