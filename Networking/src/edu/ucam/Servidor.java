package edu.ucam;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			//Objeto que se pondrá a la escucha en el puerto indicado por la constante.
			//La ip no es necesaria ya que se pone a la escucha en la máquina donde se lanza
			ServerSocket serverSocket = new ServerSocket(Cliente.PORT);

			System.out.println("Escuchando...");
			
			//Esperamos una petición (bind y listen), cuando llega (accept) se crea un objeto de socket
			//El objeto de Socket representa la comunicación con el cliente.
			Socket socket = serverSocket.accept();
		
			System.out.println("Conexion recibida, enviamos mensaje de bienvenida");
			
			//Buffer de escritura, destacar que está creado a partir del flujo de salida del socket --> socket.getOutputStream() 
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			//Enviamos este mensaje a través del socket
			pw.println("Bienvenido al servidor");
			
			//Forzamos que se vacíe el buffer, así aseguramos que el mensaje se envía 
			pw.flush();
			
			serverSocket.close();
		
		} catch (IOException e) {
		} 


	}

}
