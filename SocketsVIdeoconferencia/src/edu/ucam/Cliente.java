package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import edu.ucam.pojos.Expediente;

public class Cliente {

	
	public void execute(){
		try {
			Socket socketConServidor = new Socket("localhost", Servidor.PUERTO);
			

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketConServidor.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socketConServidor.getInputStream()));
			
			
			pw.println("1 PASS admin");
			pw.flush();
			
			System.out.println(br.readLine());
			
			
			pw.println("1 USER eeee");
			pw.flush();
			
			System.out.println(br.readLine());
			
			
			pw.println("1 USER admin");
			pw.flush();
			
			System.out.println(br.readLine());
			
			pw.println("2 PASS admin");
			pw.flush();
			
			System.out.println(br.readLine());
			
			pw.println("3 PASS admin");
			pw.flush();
			
			System.out.println(br.readLine());
			
			pw.println("4 ADDEXPEDIENTE");
			pw.flush();
			
			//Leemos la respuesta del comando	
			String msg = br.readLine();
			
			//Troceamos
			String partes [] = msg.split(" ");
			
			//Abrimos conexión a ip y puerto recibido en la respuesta del comando enviado
			System.out.println("Abriendo conexion a " + partes[3] + " " + Integer.parseInt(partes[4]));
			Socket socketDatos = new Socket(partes[3], Integer.parseInt(partes[4]));
			
			
			//Enviamos el objeto
			ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());			
			oos.writeObject(new Expediente("45", "No las tiene", null, null, null));
			
			System.out.println(br.readLine());
			
/*			
			String msg = "";		
			
			Scanner teclado = new Scanner(System.in);
			
			
			while(true){
				
				System.out.print("Introduce usuario para conectar:");
				msg = teclado.nextLine();
				
				pw.println("1 USER " + msg);
				pw.flush();
				
				System.out.println(br.readLine());
				
			}
			
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		(new Cliente()).execute();
	}

}
