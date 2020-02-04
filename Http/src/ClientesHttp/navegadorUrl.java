package ClientesHttp;
import java.net.*;


import java.io.*;

public class navegadorUrl {
	
	public static void main(String[] args) {
		try {
			
			String maquina = "www.mediavida.com";
			int puerto = 80;
			String nombreArchivo = "/index.html";
			String cadenaUrl = "http://" + maquina + ":" +puerto +nombreArchivo;
			URL miUrl = new URL("http", maquina, puerto, cadenaUrl);
			
			InputStream enStream = miUrl.openStream();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(enStream));
			String respuesta;
			respuesta = entrada.readLine();
			while(respuesta != null) {
				
				System.out.println(respuesta);
				respuesta = entrada.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
			e.printStackTrace();
		}
	}

}
