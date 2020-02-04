package TestClienteServidor;


import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Cliente {
	
	public static void main(String[] args) throws Exception {
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos2 = null;		///Los dos Sockets valen para el Multithread
		ObjectInputStream ois2 = null;
		Socket s = null;
		Socket s2 = null;
		try {
			//Instancio el server con la IP y el PORT
			s = new Socket("127.0.0.1", 5432);
			s2 = new Socket("127.0.0.1", 5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			oos2 = new ObjectOutputStream(s2.getOutputStream());
			ois2 = new ObjectInputStream(s2.getInputStream());
			// envio un nombre
			oos.writeObject("Lucas");
			oos2.writeObject("Carmen");
			
			//recibo la respuesta del servidor
			String ret = (String)ois.readObject();
			System.out.println(ret);
			String ret2 = (String)ois2.readObject();
			System.out.println(ret2);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			if (oos != null) oos.close();
			if (ois != null) ois.close(); //Cierro la conexiones
			if ( s != null) s.close();
			if (oos2 != null) oos.close();
			if (ois2 != null) ois.close(); //Cierro la conexiones
			if ( s2 != null) s.close();
		}
		
		
	}

}
