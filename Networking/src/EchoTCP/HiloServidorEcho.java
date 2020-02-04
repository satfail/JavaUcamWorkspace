package EchoTCP;
import java.io.*;

public class HiloServidorEcho implements Runnable{

	static final String mensajeFin = ".";
	MiSocketStream miSocketDatos ;
	
	public HiloServidorEcho(MiSocketStream miSocketDatos) {
		
		this.miSocketDatos = miSocketDatos;
	}
	
	public void run() {
		
		boolean hecho = false;
		String mensaje;
		
		try {
			
			while(!hecho) {
				
				mensaje = miSocketDatos.recibeMensaje();
				System.out.println("Mensaje recibido : " + mensaje);
				if((mensaje.trim())==mensajeFin) {
					System.out.println("Final de la Conexion");
					miSocketDatos.close();
					hecho = true;
				}
				
				else {
					
					miSocketDatos.enviaMensaje(mensaje);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Excepcion capturada en el hilo " + e );
		}
	}
}
