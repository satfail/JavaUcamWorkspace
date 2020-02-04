package chat;
import java.util.Scanner;

public class Cliente extends Thread {
	private static SocketStream socket ;
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		Scanner entrada = new Scanner(System.in);
		socket = new SocketStream("localhost",2019);
		String mensaje;
		cliente.start();
		try {
			while(!(mensaje = entrada.nextLine()).equalsIgnoreCase("QUIT")) {
				socket.enviaMensaje(mensaje);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {

		while(true) {
			try {
				String mensaje =  socket.recibeMensaje();
				System.out.println("> "+mensaje);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	

}
