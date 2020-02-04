package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServidor extends Thread{
	
	private Socket socket;

	public HiloServidor(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		BufferedReader br;
		PrintWriter pw;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String lineaLeida = "";
			String [] partes;
			while(!(lineaLeida = br.readLine()).equalsIgnoreCase("QUIT")){
				
				partes = lineaLeida.split(" ");//1 hola zzzz
				
				if("ADDFINCA".equals(partes[1])){
					
					int port = Servidor.damePuerto();
					
					pw.println(partes[0] + " OK localhost " + port);
					pw.flush();
					
					HiloDatos hiloDatos = new HiloDatos(port);
					hiloDatos.start();
					
					System.out.println("Seguimos esperando comandos");
				}else{
					pw.println("No es comnado finca");
				}
				pw.flush();
			}
			
		} catch (IOException e) {
			
		}
	}

}
