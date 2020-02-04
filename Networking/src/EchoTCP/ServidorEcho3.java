package EchoTCP;

import java.net.*;
import java.io.*;

public class ServidorEcho3 {
	
	public static void main(String[] args) {
		
		int puertoServidor = 13;
		String mensaje;
		
		
		try {
			
			ServerSocket miSocketConexion = new ServerSocket(puertoServidor);
			System.out.println("Servidor Echo Preparado");
			while(true) {
				System.out.println("Esperando Conexion");
				MiSocketStream miSocketDatos = new MiSocketStream(miSocketConexion.accept());
				System.out.println("Conexion Aceptada");
				Thread elHilo = new Thread(new HiloServidorEcho(miSocketDatos));
				elHilo.start();// Inicia el hilo para un cliente y continua con el bucle while para esperar a otro
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
