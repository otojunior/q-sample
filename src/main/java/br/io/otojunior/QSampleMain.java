/**
 * 
 */
package br.io.otojunior;

import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.net.ntp.NTPUDPClient;

import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * Classe principal.
 * @author Oto Soares Coelho Junior
 * @since 06/02/2023
 */
@QuarkusMain
public class QSampleMain {
	private static final String NTP_SERVER = "pool.ntp.br";
	
    /**
     * Método principal
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) throws Exception {
        var client = new NTPUDPClient();
        
        var watchStart = 0L;
        var watchEnd = 0L;
        
        try {
        	final var defaultZoneId = ZoneId.systemDefault();
        	final var inetAddr = InetAddress.getByName(NTP_SERVER);
        	final var fmthora = DateTimeFormatter.ofPattern("HH:mm:ss");
        	final var fmtdata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	final var runtime = Runtime.getRuntime();
        	
        	watchStart = System.currentTimeMillis();
        	
            client.open();
            var timeInfo = client.getTime(inetAddr);
            
            var returnTime = timeInfo
        		.getMessage()
        		.getTransmitTimeStamp()
        		.getTime();
            
			var time = LocalDateTime
				.ofInstant(Instant
				.ofEpochMilli(returnTime), defaultZoneId);

			runtime.exec(new String[] {"cmd", "/C", "time", time.format(fmthora)});
			runtime.exec(new String[] {"cmd", "/C", "date", time.format(fmtdata)});

            System.out.println("NTP time: " + time.format(fmthora));
            System.out.println("NTP date: " + time.format(fmtdata));
        } finally {
            client.close();
            watchEnd = System.currentTimeMillis();
            System.out.println("Calculate time: " + (watchEnd-watchStart));
        }
    }
}
