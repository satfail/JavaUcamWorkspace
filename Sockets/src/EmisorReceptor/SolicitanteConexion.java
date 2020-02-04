package EmisorReceptor;
//Socket en modo Stream ---> TCP Socket Flujo de da Datos E/S en un camino
//---> TCP Establecimiento de conexion por otro lado
import java.net.*;
import java.io.*;
public class SolicitanteConexion {
	
	public static void main(String[] args) {
		
		try {
			
			Socket miSocket = new Socket("127.0.0.1", 5432);
			//Esperamos a conectar(parada), no es bloqueante pero no se puede establecer el flujo de datos
			//hasta que la conexion este establecida
			System.out.println("Solicitud de conexion concedida");
			
			//Se obtiene flujo de entrada
			InputStream is = miSocket.getInputStream();//Recibe
			
			//Se crea un objeto BufferedReader para la entrada de modo caracter
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); //Se espera hasta leer(parada)
			System.out.println("Esperando a leer");//Se para para leer
			//Se lee el mensaje que viene input
			String mensaje = br.readLine();
			
			System.out.println("Mensaje recibido : " + mensaje);
			miSocket.close();
			System.out.println("Conexion Cerrada");
		}
		
		
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}

}
