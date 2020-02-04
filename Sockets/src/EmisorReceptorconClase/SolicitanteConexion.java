package EmisorReceptorconClase;
import java.net.*;
import java.io.*;
public class SolicitanteConexion {
	
	public static void main(String[] args) {
		
		try {
			MiSocketStream socketDatos = new MiSocketStream ("127.0.0.1", 5242);
			System.out.println("Conexion Establecida");
			
			String mensaje = socketDatos.recibeMensaje();
			System.out.println("Mensaje recibido : " + mensaje);
			socketDatos.enviaMensaje("Bidireccional!");
			
			socketDatos.close();
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		
	}

}
