/**
 * 
 */
package br.io.otojunior;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * Classe principal.
 * @author Oto Soares Coelho Junior
 * @since 06/02/2023
 */
@QuarkusMain
public class QSampleMain {
    /**
     * Método principal
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        Quarkus.run(QSampleApplication.class, args);
    }
}
