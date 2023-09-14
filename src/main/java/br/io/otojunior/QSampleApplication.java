/**
 * 
 */
package br.io.otojunior;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
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
        log.debug("Aplicacao Quarkus iniciada");
        Quarkus.waitForExit();
        return 0;
    }
}
