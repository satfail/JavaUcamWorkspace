package edu.ucam;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static int puerto = 2019;
	
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(2018);
			
			while(true){
			
				Socket socket = ss.accept();
				HiloServidor hiloServidor = new HiloServidor(socket);
				hiloServidor.start();
			}
			
			
			
		}catch (Exception e){
			
		}

	}

	public static int damePuerto() {
		
		return puerto++;
	}

}
