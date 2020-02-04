package EchoTCP;

import java.io.*;

public class ClienteEcho2 {

	static final String mensajeFin = ".";
	
	public static void main(String[] args) {
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		try {
			
			System.out.println("Bienvenido al Cliente Echo\n"
					+ "Cual es el nombre de la maquina servidora? ");
			
			String nombreMaquina = br.readLine();
			if (nombreMaquina.length() == 0)
				nombreMaquina = "localhost";
			
			System.out.println("Cual es el puerto de la maquina servidora?");
			String numPuerto = br.readLine();
			if(numPuerto.length() == 0) {
				
				numPuerto = "13";
			}
			
			ClienteEchoAuxiliar2 auxiliar = new ClienteEchoAuxiliar2(nombreMaquina, numPuerto);
			
			boolean hecho = false;
			String mensaje, eco;
			
			while(!hecho) {
				
				System.out.println("Introduzca una linea para recibir eco  del servidor o un unico punto para terminar");
				mensaje = br.readLine();
				
				if ((mensaje.trim()).equals(".")) {
					
					hecho = true;
					auxiliar.hecho();
				}
				else {
					
					eco = auxiliar.obtenerEcho(mensaje);
					System.out.println(eco);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
