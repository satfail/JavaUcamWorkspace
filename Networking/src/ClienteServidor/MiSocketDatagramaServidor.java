package ClienteServidor;

import java.net.*;
import java.io.*;

public class MiSocketDatagramaServidor extends DatagramSocket {
	
	static final int MAX_LON = 100;
	public MiSocketDatagramaServidor(int numPuerto)  throws SocketException{
		super(numPuerto);
	}
	
	public void enviaMensaje (InetAddress maquinaRecptora, int puertoReceptor, String mensaje) throws IOException {
		
		
		byte [ ] almacenEnvio = mensaje.getBytes();
		DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length,maquinaRecptora,puertoReceptor);
		this.send(datagrama);
		
		
	}
	
	public String recibeMensaje() throws  IOException{
		
		
		byte[] almacenRecpcion = new byte [MAX_LON];
		DatagramPacket datagram = new DatagramPacket(almacenRecpcion, MAX_LON);
		this.receive(datagram);
		String mensaje = new String (almacenRecpcion);

		return mensaje;
	}
	
	public MensajeDatagrama recibeMensajeYEmisor() throws  IOException{
		
		
		byte[] almacenRecpcion = new byte [MAX_LON];
		DatagramPacket datagram = new DatagramPacket(almacenRecpcion, MAX_LON);
		this.receive(datagram);
		MensajeDatagrama valorDevuelto = new MensajeDatagrama();
		valorDevuelto.fijaValor(new String(almacenRecpcion), datagram.getAddress(), datagram.getPort());
		
		return valorDevuelto;
		

	}

}
