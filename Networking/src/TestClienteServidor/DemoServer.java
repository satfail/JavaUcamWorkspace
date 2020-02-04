package TestClienteServidor;
//Server es el programa que una vez levantado permanece a la escucha para que se conecten los Clientes.
//Para escuchar utilizaremos la instancia ServerSocket que recibe como parámetro en su constructor el puerto
//Una vez establecida la conexion el ServerSocket, devuelve un Socket a través del cual se establece la conexion Cliente-Servidor

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoServer {

	public static void main(String[] args) throws Exception{
		
		ObjectInputStream ois= null;
		ObjectOutputStream oos = null;
		boolean espera = true;
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432); ///Instancio un ServerSocket que va a ese puerto
		
		while(espera) {
			try {
				
				s = ss.accept(); //El server Socket da el Socket, el server espera a la conexion del cliente
								 //Se bloquea el programa en esta linea y solo avanza cuando el cliente se haya conectado
								 //Cuando se produzca esta conexión se retorna un Socket para realizar dialogo Cliente-Servidor
				
				
				//informacion de la consola, IP del cliente
				System.out.println("Se conectaron desde la IP : " + s.getInetAddress());
				
				//enmascaro la entrada y salida de Bytes, estas clases permiten leer y escribir objetos a través de red
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				//Leo el nombre que envia el  Cliente
				String nom = (String) ois.readObject();//Enviado por el Cliente
				String saludo = "Hola  mundo!! Eres " + nom + " --- " + System.currentTimeMillis();
				//envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("Saludo enviado...");
				
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
			
			finally {
				if (oos != null) oos.close();
				if (ois != null) ois.close(); //Cierro la conexiones
				if ( s != null) s.close();
				if ( ss != null) ss.close();
				System.out.println("Conexión cerrada! ");
				espera = false;
				
			}
		}
	}
	
}
