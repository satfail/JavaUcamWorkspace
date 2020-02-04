package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(5432);
		
		while(true) {
			System.out.println("Esperando Conexion...");
			
			//Creo buffer para recibir
			byte[] bRecibe = new byte[256];
			//recibo Datagrama del Cliente
			DatagramPacket packet = new DatagramPacket(bRecibe, bRecibe.length);
			socket.receive(packet);
			System.out.println("Conexion Recibida!! ");
			
			//Envio Saludo al Cliente con la info recibida ,un nombre por ejemplo
			String nombre = new String(packet.getData(),0,packet.getLength());
			String saludo = "Hola como estas ? " + nombre +"-----" + System.currentTimeMillis();
			System.out.println("Enviando el saludo = " + saludo + ".....");
			
			//buffer para el saludo
			byte[] bEnvia = saludo.getBytes();
			System.out.println(saludo.getBytes());
			
			//Lo envio
			InetAddress address = packet.getAddress();
			packet = new DatagramPacket(bEnvia, bEnvia.length,address,packet.getPort());
			socket.send(packet);
			System.out.println("Saludo enviado");
		}
	}

}
