package chat;

import java.net.ServerSocket;
import java.util.ArrayList;


public class Servidor {
static ArrayList<HiloServidor> hilos = new ArrayList<HiloServidor>();
public void  launch(){
	String mensaje;

	
	try {
		
		ServerSocket miSocketConexion = new ServerSocket(2019);
		System.out.println("Servidor Preparado");
		while(true) {
			System.out.println("Esperando Conexion");
			SocketStream miSocketDatos = new SocketStream(miSocketConexion.accept());
			System.out.println("Conexion Aceptada");
			HiloServidor hilo = new HiloServidor(miSocketDatos,this);
			hilos.add(hilo);
			hilo.start();
			
			
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void enviarTodos(String mensaje) {
	// por cada tipo HiloServidor en hilos que hemos creado mandamos un mensaje
	// que es el del cliente
	for(HiloServidor hiloServidor : hilos){
		try {
			hiloServidor.socketStream.enviaMensaje(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public static void main(String[] args) {
	(new Servidor()).launch();		
}

}

