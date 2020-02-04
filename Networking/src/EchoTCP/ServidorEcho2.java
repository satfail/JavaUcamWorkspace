package EchoTCP;

import java.io.*;
import java.net.*;


public class ServidorEcho2 {
	
	static final String mensajeFin = ".";
	public static void main(String[] args) {
		
		int puertoServidor = 13;
		String mensaje;
		try {
			
			ServerSocket miSocketConexion = new ServerSocket(puertoServidor);
			System.err.println("Servidor Echo listo");
			
			while(true) {
				
				System.out.println("Esperando una conexion...");
				MiSocketStream miSocketDatos = new MiSocketStream(miSocketConexion.accept());
				System.out.println("Conexion Aceptada");
				boolean hecho = false;
				
				while(!hecho) {
					
					mensaje = miSocketDatos.recibeMensaje();
					System.out.println("Mensaje recibido " + mensaje);
					if((mensaje.trim()).equals(mensajeFin)) {
						System.out.println("Final de Sesion");
						miSocketDatos.close();
					}
					else {
						
						miSocketDatos.enviaMensaje(mensaje);
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
