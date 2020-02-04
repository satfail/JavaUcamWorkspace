package Multidifusion;

import java.io.*;
import java.net.*;

//No lo meto en el grupo MD,aunque se podria, solo manda un mensaje a ese grupo.
public class Ejemplo1Emisor {

	public static void main(String[] args) {
		
		MulticastSocket s;
		InetAddress grupo;
		
		try {
			//Defino direccion MD, puerto y le doy timetolive al mensaje
			grupo = InetAddress.getByName("239.1.2.3");
			s = new MulticastSocket(3456);
			s.setTimeToLive(32); 
			
			String msj = "Hola Mundo";
			DatagramPacket paquete = new DatagramPacket(msj.getBytes(), msj.length(),grupo,3456);
			
			s.send(paquete);
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
