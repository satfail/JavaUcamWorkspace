package ClienteServidor;
import java.io.*;
import java.util.Date;


public class ServidorDaytime1 {

	public static void main(String[] args) {
		
		int puertoServidor = 13;
		
		try {
			
			MiSocketDatagramaServidor miSocket = new MiSocketDatagramaServidor(puertoServidor);
			System.out.println("El servidor Daytime esta listo");
			
			
			while(true) {
				
				MensajeDatagrama peticion = miSocket.recibeMensajeYEmisor();
				System.out.println("Peticion Recibida");
				//Lo importante aqui no es el mensaje, sino la informacion de la conexion IP y puerto
				
				Date marcaTiempo = new Date();
				System.out.println("Marca de tiempo enviada " + marcaTiempo.toString());
				miSocket.enviaMensaje(peticion.getDireccionEmisor(), peticion.getPuertoEmisor(), marcaTiempo.toString());	
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			
	}
}
