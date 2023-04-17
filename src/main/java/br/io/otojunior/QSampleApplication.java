/**
 * 
 */
package br.io.otojunior;

import org.apache.commons.lang3.ObjectUtils;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de aplicação principal.
 * @author Oto Soares Coelho Junior
 * @since 06/02/2023
 */
@Slf4j
public class QSampleApplication implements QuarkusApplication {
    /**
     * {@inheritDoc}
     */
    @Override
    public int run(String... args) throws Exception {
        log.debug("App Quarkus iniciada");
        Quarkus.waitForExit();
        return 0;
    }
}
