package EmisorReceptor;

//Socket en modo Stream ---> TCP Socket Flujo de da Datos E/S en un camino
					  //---> TCP Establecimiento de conexion por otro lado
import java.net.*;
import java.io.*;

public class AceptadorConexion {
	public static void main(String[] args) {
		
		try {
			// Socket para la conexion
			ServerSocket socket  = new ServerSocket(5432);
			System.out.println("Preparado para aceptar conexion...");
			//Se crea socket de datos cuando se establece la conexion
			Socket socketDatos = socket.accept(); //(parada)
			System.out.println("Conexion Establecida ");
			
			OutputStream os = socketDatos.getOutputStream(); //Emite
			PrintWriter pw = new PrintWriter ( new OutputStreamWriter(os));
			pw.println("Hola Mundo!");
			pw.flush(); //Limpiamos el buffer de datos
			System.out.println("Mensaje Enviado");
			socketDatos.close();
			socket.close();
			System.out.println("Conexion cerrada");
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}

}
