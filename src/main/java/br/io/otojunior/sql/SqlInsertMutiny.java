package br.io.otojunior.sql;

import static java.util.UUID.randomUUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * SQL INSERT usando o PgPool / Mutiny.
 * @author Oto Soares Coelho Junior
 * @since 11/04/2023
 */
@Slf4j
@ApplicationScoped
public class SqlInsertMutiny {
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
				.execute(Tuple.of(-1, randomUUID().toString()));
    		var insert2 = conn
				.preparedQuery(INSERT)
				.execute(Tuple.of(-2, randomUUID().toString()));
    		return Uni.combine().all()
				.unis(insert1, insert2)
				.discardItems();
    		})
		.subscribe()
		.with(
			onItemCallback -> log.info("Inserido Itens"),
			onFailureCallback -> log.error("Erro de Inserts"));
	}
}
