package edu.ucam.application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.ucam.pojos.Medico;

/* Servidor que crea hilos por cada cliente, le pasamos el Socket con la conexion.
 * 
 * */

public class Servidor {
	
	static final int puertoMensajes = 2019;
	static final String ip = "localhost";

	
	
	public void lanzarServidor() {
		
		try {
			//Creamos el socket para el servidor,
			ServerSocket socketServidor = new ServerSocket(puertoMensajes);
			System.out.println("Servidor Preparado");
			//El bucle queda bloqueado hasta que recibimos una conexión del cliente
			// Una vez recibida creamos el hilo de Mensajería
			while(true) {
				Socket socketServidorMensajeria =socketServidor.accept();
				HiloMensajeria hiloMensajes = new HiloMensajeria(socketServidorMensajeria);
				System.out.println("Se ha establecido conexion de Mensajeria en el Puerto : "  + socketServidor.getLocalPort());
				hiloMensajes.start();

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static int getPuertomensajes() {
		return puertoMensajes;
	}

	public static String getIp() {
		return ip;
	}
	

}
