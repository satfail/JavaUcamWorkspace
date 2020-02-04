package EmisorReceptorconClase;
import java.net.*;
import java.io.*;
public class AceptadorConexion {
	
	
	public static void main(String[] args) {
		try {
		
			ServerSocket socketConexion = new ServerSocket(5242);
			System.out.println("Esperando para recibir conexion...");
			
			MiSocketStream socketDatos = new MiSocketStream(socketConexion.accept());
			System.out.println("Conexion Aceptada");
			
			socketDatos.enviaMensaje("Hola Mundo!!");
			System.out.println(socketDatos.recibeMensaje());
			socketDatos.close();
			socketConexion.close();
			System.out.println("Conexion Cerrada");
		
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
	}

}
