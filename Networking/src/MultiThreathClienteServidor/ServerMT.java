package MultiThreathClienteServidor;

import java.io.*;
import java.net.*;

public class ServerMT {
	
	public static void main(String[] args) throws Exception {
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		boolean espera = true;
		
		while(espera) {
			
			try {
				
				s = ss.accept();
				(new Tarea(s)).start(); //Creo un hilo que gestiona E/S del servidor
				
			}
			
			catch(Exception ex) {
				
				ex.printStackTrace();
			}
		}
		
	}
	static class Tarea extends Thread{
		
		private Socket s = null;
		private ObjectInputStream ois = null;
		private ObjectOutputStream oos = null;
		
		public Tarea(Socket socket) {
			
			this.s = socket;
		}
		
		public void run() {
			
			try {
				
				System.out.println("Se conectaron desde la IP : " + s.getInetAddress());
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				String nom = (String) ois.readObject();
				String saludo = "Hola  mundo!! Eres " + nom + " --- " + System.currentTimeMillis();
				
				oos.writeObject(saludo);
				System.out.println("Saludo enviado2 ");
			}
			
			catch(Exception ex){
				
				ex.printStackTrace();
			}
			
			finally {
				
				try {
					
					if (oos != null) oos.close();
					if (ois != null) ois.close(); //Cierro la conexiones
					if ( s != null) s.close();
					System.out.println("Conexión cerrada! ");
				}
				catch(Exception ex){
					
					ex.printStackTrace();
				}
			}	
		}
	}
}
