package ClienteServidor;

import java.io.*;


public class ClienteDaytime1 {
	
	public static void main(String[] args) {
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br =  new BufferedReader(is);
		
		try {
			System.out.println("Bienvenido a la Maquina del Cliente\n"
					+ "Cual es el nombre de la Maquina Servidora?");
			String nombremaquina = br.readLine();
			if ( nombremaquina.length() == 0) {
				
				nombremaquina = "localhost";
			}
			
			System.out.println("Introduzca el numero de puerto");
			
			String numPuerto  = br.readLine();
			
			if (numPuerto.length() == 0 )
				numPuerto = "13";
			
			System.out.println("Time Stamp recibida " +
			ClienteDaytimeAuxiliar1.obtenerMarcatiempo(nombremaquina,numPuerto));
			
			
		}
		
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
			
	}
}
