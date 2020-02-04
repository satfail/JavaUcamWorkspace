package ClienteServidor;

import java.net.*;

public class ClienteDaytimeAuxiliar1 {
	
		public  static String obtenerMarcatiempo(String nombremaquina, String numpuerto) {
			
			String marcaTiempo = "";
			try {
				
				InetAddress serverHost = InetAddress.getByName(nombremaquina);
				int serverPort = Integer.parseInt(numpuerto);
			
				MiSocketDatagramaCliente miSocket = new MiSocketDatagramaCliente();
				
				miSocket.enviaMensaje(serverHost, serverPort, "Hola mundo");
				
				marcaTiempo = miSocket.recibeMensaje();
				miSocket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return marcaTiempo;
		}
	

}
