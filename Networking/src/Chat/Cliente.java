package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread{ //Extiende de thread xk tengo que hacer dos cosas a la vez
									 // enviar mensaje al servidor y recibir la respuesta de el
	
	private BufferedReader br; //hacemos un atributo de br par a que llegue a run tb
	
	public void launch(){
		try {
			Socket socket = new Socket("localhost", 2018);
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//Leemos mensaje de bienvenida
			System.out.println(br.readLine());
			
			Scanner sc = new Scanner(System.in);
			
			this.start(); //lanzamos el hilo de recepcion
			
			String lineaLeida = "";
			while(!(lineaLeida = sc.nextLine()).equalsIgnoreCase("QUIT")){ //Estamos esperando escribir linea por teclado
				pw.println(lineaLeida);
				pw.flush();
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		
			try {
				while(true){ //
					System.out.println(">" + br.readLine()); ///Tb estamos a la espera para recibir linea
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	

	public static void main(String[] args) {
		(new Cliente()).launch(); //Lanzamos nuevo cliente
	}

}
