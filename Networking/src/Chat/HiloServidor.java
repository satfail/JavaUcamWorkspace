package Chat;

//Capa intermedia donde creamos los hilos del server

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
	
	private Socket socket;
	private PrintWriter pw;
	private Servidor servidor;

	public HiloServidor(Socket socket, Servidor servidor){ //Recibe como parametro el servidor para operar
		this.socket = socket;
		this.servidor = servidor;
	}
	
	public void run(){
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			pw.println("Hola, bienvenido");
			pw.flush();
			
			String lineaLeida = "";
			while(!(lineaLeida = br.readLine()).equalsIgnoreCase("QUIT")){
				
				this.servidor.sendMessageToClients(lineaLeida);  //Mando a todos los clientes la linea recibida por el servidor
				//Como lo he recibido como parametro utilizo su metodo desde aqui donde recibo la linea
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void sendMessageToClient(String lineaLeida) {
		pw.println(lineaLeida);
		pw.flush();
		
	}

}
