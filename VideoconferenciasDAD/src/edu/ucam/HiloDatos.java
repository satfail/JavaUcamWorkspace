package edu.ucam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloDatos extends Thread{
	
	private int port;
	
	public HiloDatos(int port){
		this.port = port;
	}
	
	public void run(){
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(this.port);
			System.out.println("Esperando conexión en canal de datos");
			Socket canalDatos = serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
