package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import edu.ucam.pojos.Expediente;

public class Servidor {
	
	public static final int PUERTO = 2020;
	
	public void execute(){
		try {
			ServerSocket serverSocket = new ServerSocket(Servidor.PUERTO);
			
			System.out.println("Servidor a la escucha...");
			Socket socketConElCliente = serverSocket.accept();
			
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketConElCliente.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socketConElCliente.getInputStream()));
			
			String msg = "";				
				
			boolean salir = false;
			
			
			//COMPROBAR USUARIO
			do{
				
				//Leo lo que me envían por el socket
				msg = br.readLine();
				
				System.out.println("Mensaje recibido: '" + msg + "'");
				
				//Troceo la cadena por espacios "531 USER admin"
				String partes[] = msg.split(" ");
			
				if (partes.length == 3){
					
					//Compruebo que el comando es USER
					if("USER".equals(partes[1])){
						
						//Compruebo que el usuario es admin
						if("admin".equals(partes[2])){
							msg = "Usuario correcto. Envíe contraseña";
							salir = true;
						}else{
							msg = "Usuario no válido. Envíe <id> USER <usuario>";
						}
					
					}else{
						msg = "Comando no válido. Envíe <id> USER <usuario>";
					}
				}else{
					msg = "Comando no válido. Envíe <id> USER <usuario>";
				}
				
				

				pw.println(msg);
				pw.flush();
				
			}while(!salir);
			
			
			
			//COMPROBAR CLAVE
			salir = false;
			
			do{
				
				//Leo lo que me envían por el socket
				msg = br.readLine();
				
				System.out.println("Mensaje recibido: '" + msg + "'");
				
				//Troceo la cadena por espacios "531 USER admin"
				String partes[] = msg.split(" ");
			
				if (partes.length == 3){
					
					//Compruebo que el comando es USER
					if("PASS".equals(partes[1])){
						
						//Compruebo que el usuario es admin
						if("admin".equals(partes[2])){
							msg = "Clave correcta. Bienvenido";
							salir = true;
						}else{
							msg = "Contraseña no válida. Envíe <id> PASS <usuario>";
						}
					
					}else{
						msg = "Comando no válido. Envíe <id> PASS <usuario>";
					}
				}else{
					msg = "Comando no válido. Envíe <id> PASS <usuario>";
				}
				
				

				pw.println(msg);
				pw.flush();
				
			}while(!salir);
				
				
			
			//COMENZAMOS A PROCESAR COMANDOS
			
			int puertoDatos = 3000;
			
			while(true){
				//Leo lo que me envían por el socket
				msg = br.readLine();
				
				System.out.println("Mensaje recibido: '" + msg + "'");
				
				//Troceo la cadena por espacios "531 USER admin"
				String partes[] = msg.split(" ");
				
				if (partes.length >= 2){
					
					switch(partes[1]){
					
					case "ADDEXPEDIENTE":
						
						ServerSocket serverSocketDatos = new ServerSocket(puertoDatos);
						
						//Enviarle al cliente la ip y el puerto al que debe conectarse
						pw.println("OK " + partes[0] + " 200 localhost " + puertoDatos++);
						pw.flush();
						
						Socket canalDatos = serverSocketDatos.accept();
						
						ObjectInputStream ois = new ObjectInputStream(canalDatos.getInputStream());
						Expediente expediente = (Expediente)ois.readObject();
						
						System.out.println(expediente.getObservaciones());
						
						msg = "ADDEXPEDIENTE RECIBIDO";
						break;
						
					case "GETEXPEDIENTE":
						msg = "GETEXPEDIENTE RECIBIDO";
						break;
						
					default:
						msg = "Comando no encontrado";
					}
					
				}else{
					msg = "Mensaje no válido";
				}
				
				

				pw.println(msg);
				pw.flush();
				
			}
			
		} catch (IOException e) {
			//System.out.println("Fin del programa");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		(new Servidor()).execute();

	}

}
