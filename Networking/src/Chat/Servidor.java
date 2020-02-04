package Chat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	
	private ArrayList<HiloServidor> hilos = new ArrayList<HiloServidor>(); 
	//Creo array de la clase hilo servidor para poder recorrerlos y mandar mesajes a todos
	
	public void launch(){
		try {						
			ServerSocket serverSocket = new ServerSocket(2018);			
			while(true){
							
				System.out.println("Escuchando...");
				Socket socket = serverSocket.accept();
				System.out.println("Conexión recibida");
				
				HiloServidor hiloServidor = new HiloServidor(socket, this);
				hilos.add(hiloServidor);
				hiloServidor.start();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		(new Servidor()).launch();		
	}

	public void sendMessageToClients(String lineaLeida) {
		// por cada tipo HiloServidor en hilos que hemos creado mandamos un mensaje
		// que es el del cliente
		for(HiloServidor hiloServidor : hilos){
			hiloServidor.sendMessageToClient(lineaLeida);
		}
		
	}

}
