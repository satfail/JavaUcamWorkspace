package chat;

import java.net.Socket;

public class HiloServidor extends Thread{
	Servidor servidor;
	SocketStream socketStream;
	
	public HiloServidor(SocketStream socketStream, Servidor servidor) {
		this.socketStream = socketStream;
		this.servidor = servidor;
	}
	
	
	public void run() {
		
		boolean hecho = false;
		String mensaje;
		try {
			while(!hecho) {
				
				mensaje = socketStream.recibeMensaje();
				System.out.println("Mensaje recibido : " + mensaje);
				if((mensaje.equals("QUIT"))){
					System.out.println("Final de la Conexion");
					socketStream.close();
					hecho = true;
				}
				
				else {
					this.servidor.enviarTodos(mensaje);
				}
			}
		
	} catch (Exception e) {
		System.out.println("Excepcion capturada en el hilo " + e );
		
	}
	
	}
}



