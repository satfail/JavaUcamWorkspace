package EchoTCP;
import java.net.*;
import java.io.*;


public class ClienteEchoAuxiliar2  {
	
	static final String mensajeFin = ".";
	private MiSocketStream miSocket;
	private InetAddress maquinaServidora;
	private int puertoServidor;
	
	public ClienteEchoAuxiliar2(String nombreMaquina, String numPuerto) throws SocketException, UnknownHostException,IOException {
		
		this.maquinaServidora = InetAddress.getByName(nombreMaquina);
		this.puertoServidor = Integer.parseInt(numPuerto);
		this.miSocket = new MiSocketStream(nombreMaquina, this.puertoServidor);
		System.out.println("Peticion de conexion hecha");
	}
	
	public String obtenerEcho (String mensaje) throws Exception{
		
		String echo = "";
		miSocket.enviaMensaje(mensaje);
		echo = miSocket.recibeMensaje();
		
		return echo;
	}
	
	public void hecho() throws Exception{
		
		miSocket.enviaMensaje(mensajeFin);
		miSocket.close();
		
		
		
	}

}
