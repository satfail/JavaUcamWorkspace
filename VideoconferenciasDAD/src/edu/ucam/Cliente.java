package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		BufferedReader br;
		PrintWriter pw;
		try {
			
			Socket socket = new Socket("localhost", 2018);
			
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			pw.println("1 ADDFINCA zzz");
			pw.flush();
			
			String linea = br.readLine();
			System.out.println(linea);
			
			String [] partes = linea.split(" ");
			
			System.out.println("Conectándose a "+ partes[2] + " " + partes[3]);
			Socket canalDatos = new Socket(partes[2], Integer.parseInt(partes[3]));
			
			pw.println("1 otra zzz");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
