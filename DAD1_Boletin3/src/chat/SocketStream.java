package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketStream extends Socket {
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public SocketStream (String ip, int puerto) {
		
		try {
			this.socket = new Socket(ip,puerto);
			establecerFlujos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//Constructor para Servidor
	public SocketStream(Socket socket) throws IOException{ //Constructor para aceptador
		
		this.socket = socket;
		establecerFlujos();
	}
	private void establecerFlujos() throws IOException{
		//Para recibir
		InputStream is = socket.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		//Para emitir
		OutputStream os = socket.getOutputStream();
		pw = new PrintWriter(new OutputStreamWriter(os));
		
		
		
	}
	
	public void enviaMensaje(String mensaje) throws Exception {

		pw.println(mensaje);
		pw.flush();
		
	}
	
	
	public String recibeMensaje() throws Exception{
		
		String mensaje = br.readLine();
		return mensaje;
	}
	

	
	public void close() throws IOException {
		
		socket.close();
	}

}
