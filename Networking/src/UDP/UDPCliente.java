package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente {
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket socket = new DatagramSocket();
		//buffers
		byte[] bEnviar = "Carmencita".getBytes();
		byte[] ip = {127,0,0,1};
		InetAddress address = InetAddress.getByAddress(ip);// Coge la ip del Array creado anteriormente
		
		//paquete de info que se envia dato+metadato+ip+puerto
		DatagramPacket packet = new DatagramPacket(bEnviar, bEnviar.length,address,5432);
		//Envio la respuesta
		socket.send(packet);
		
		//buffer para recibir
		byte[] bRecibe = new byte[256]; //Recive un array de 256 bytes
		packet = new DatagramPacket(bRecibe, bRecibe.length,address,5432);
		socket.receive(packet);
		String saludo = new String ( packet.getData(),0,packet.getLength());
		System.out.println(saludo);
		socket.close();
		
		
	}

}
