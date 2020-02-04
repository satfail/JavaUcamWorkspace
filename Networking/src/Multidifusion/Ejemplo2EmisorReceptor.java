package Multidifusion;

import java.io.*;
import java.net.*;

//Envio y recepcion MD , se  crea hilo para estar a la escucha en el grupo MD
public class Ejemplo2EmisorReceptor {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress grupo = InetAddress.getByName("239.1.2.3");
			int puerto = 3456;
			MulticastSocket socket = null;
			
			//Creo el hilo para recibir mensaje tiene su bucle infinto escuchando, con el recieve bloquendo
			Thread elHilo = new Thread(new HiloLector(grupo, puerto));
			elHilo.start();
			
			System.out.println("Pulse intro cuando desee enviar ");
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			br.readLine();
			String msj = br.readLine();
			byte datos[] = msj.getBytes();
			DatagramPacket paquete = new DatagramPacket(datos,datos.length, grupo, puerto);
			socket = new MulticastSocket(puerto);
			socket.setTimeToLive(0);
			socket.send(paquete);
			socket.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
