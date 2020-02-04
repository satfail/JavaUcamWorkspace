package EnviarRecibirBytes;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

// Si necesitamos escrbir un cliente que se conecte respetando un tipo de protocolo a un servidor hay que manejarse a mas bajo nivel
// para ello enviamos y recibimos bytes
public class ServerB {

	private static final int BUFFER_LENGTH = 3;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		
		while(true) {
			
			try {
				
				s = ss.accept();
				System.out.println("El cliente se conecto desde la IP : " + s.getInetAddress());
				//Enmascara E/S de bytes
				br = new BufferedReader ( new InputStreamReader(s.getInputStream()));
				bw = new BufferedWriter ( new PrintWriter(s.getOutputStream()));
				
				char bEnviar[];
				char bRecive[] = new char[BUFFER_LENGTH];
				
				StringBuffer sb = new StringBuffer();
				
				int n;
				while(( n = br.read(bRecive)) == BUFFER_LENGTH) { // Iteramos hasta que la cantidad del buffer sea difente a 3, estamos al final
					System.out.println(sb);											  // Lee PABLO 1º Iteracion PAB, entra otra vez 2º LO, es menor ultima vez que itera
					sb.append(bRecive); ///Los va añadiendo
				}
				System.out.println(sb);
				sb.append(bRecive,0,n);
				String saludo = "Hola " + sb + " --- " + System.currentTimeMillis();
				bEnviar = saludo.toCharArray(); //Convierte el String en un array de caracteres y lo envia al cliente con bw.write
				bw.write(bEnviar);
				bw.flush(); // Libero bw
				System.out.println("Saludo Enviado....");
			}
			
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
			finally {
				
				if (bw != null) bw.close();
				if (br != null) br.close();
				if (s != null) s.close();
				System.out.println("Conexion Cerrada");
			}
		}
		
	}
}
