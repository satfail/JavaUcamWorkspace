package Multidifusion;

import java.net.*;
import java.io.*;

public class HiloLector implements  Runnable {
	
	static final int MAX_LON = 30;
	private InetAddress grupo;
	private int puerto;
	
	
	
	public HiloLector(InetAddress grupo, int puerto) {
		
		this.grupo = grupo;
		this.puerto = puerto;
	}



	public void run() {
		
		try {
			
			MulticastSocket s = new MulticastSocket(puerto);
			s.joinGroup(grupo);
			
			while(true) {
				byte []  datos = new byte[MAX_LON];
				DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo,puerto);
				s.receive(paquete);
				String msj = new String(paquete.getData());
				System.out.println(msj);
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
} 


