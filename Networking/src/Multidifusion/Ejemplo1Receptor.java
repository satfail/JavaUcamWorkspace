package Multidifusion;

import java.io.*;
import java.net.*;

//Se une a grupo MC para recibir mensajes
//Por otro lado se conecta al socket para enviarlos

public class Ejemplo1Receptor {

	public static void main(String[] args) {
		
		MulticastSocket s;
		InetAddress grupo;
		
		try {
			
			grupo = InetAddress.getByName("239.1.2.3");
			s = new MulticastSocket(3456);
			s.joinGroup(grupo);
			byte[] almacen = new byte[100];
			DatagramPacket recibido = new DatagramPacket(almacen, almacen.length);
			s.receive(recibido);
			System.out.println(new String(almacen));
			s.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
