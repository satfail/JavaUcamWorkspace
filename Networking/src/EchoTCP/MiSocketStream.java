package EchoTCP;
//Subclase que hereda de Socket, para envolver todas las operaciones con Sockets
import java.net.*;
import java.io.*;

public class MiSocketStream extends Socket{
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public MiSocketStream(String ip, int puerto) throws SocketException , IOException { //Constructor para solicitante
		
		socket = new Socket (ip, puerto);
		establecerFlujos();
	}
	
	public MiSocketStream(Socket socket) throws IOException{ //Constructor para aceptador
		
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
