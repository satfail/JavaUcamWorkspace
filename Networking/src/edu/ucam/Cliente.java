package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
	//Constante con el número de puerto
	public static final int PORT = 2017;

	public static void main(String[] args) {

		try {
			System.out.println("Estableciendo conexion con el servidor...");
			
			//Establecemos conexión con el servidor. Son necesarios ip local y puerto
			Socket socket = new Socket("127.0.0.1", Cliente.PORT);
			
			System.out.println("Conexion establecida. Creamos buffer de lectura");
			
			//Buffer de lectura, destacar que está creado a partir del flujo de entrada del socket, socket.getInputStream()
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("Esperamos hasta recibir una linea...");
			
			//Esperamos a que el buffer se llene con una línea, cuando esto sucede el método readLine devuelve una cadena
			//Guardamos la cadena en la variable lineaLeida.
			String lineaLeida = br.readLine(); 
			
			System.out.println("Ha llegado este mensaje: '" + lineaLeida + "'");
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}
