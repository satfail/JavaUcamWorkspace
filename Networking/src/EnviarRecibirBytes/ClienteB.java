package EnviarRecibirBytes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClienteB {

	private static final int BUFFER_LENGTH = 3;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		try {
			s = new Socket("127.0.0.1", 5432);
			bw = new BufferedWriter ( new PrintWriter(s.getOutputStream()));
			br = new BufferedReader ( new InputStreamReader(s.getInputStream()));
			
			char clienteEnvia[] = "Lucas".toCharArray();
			char clienteRecibe[] = new char[BUFFER_LENGTH];
			bw.write(clienteEnvia);
			bw.flush();
			StringBuffer sb = new StringBuffer(); //BUffer para recibir tipo String
			
			int n;
			while( (n = br.read(clienteRecibe)) == BUFFER_LENGTH) {
				
				sb.append(clienteRecibe);
			}
			sb.append(clienteRecibe, 0,n);
			System.out.println(sb);
					
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			
			if (bw != null) bw.close();
			if (br != null) br.close();
			if (s != null) s.close();
		}
	}
}
