/**
 * 
 */
package br.io.otojunior;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Bean 1 de exemplo de eventos Startup/Shutdown.
 * @author Oto Soares Coelho Junior
 * @since 10/04/2023
 */
@Slf4j
@ApplicationScoped
public class QSampleInitBean1 {
	/**
	 * Evento de Startup
	 * @param ev {@link StartupEvent}
	 */
	void onStart(@Observes StartupEvent ev) {
		log.info("Bean 1: evento STARTUP");
	}

	/**
	 * Evento de Shutdown
	 * @param ev {@link ShutdownEvent}
	 */
	void onStop(@Observes ShutdownEvent ev) {
		log.info(
			"Bean 1: evento SHUTDOWN / Standard Shutdown: {}",
			ev.isStandardShutdown());
	}
}
