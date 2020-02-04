package SocketSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){

		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		
		campoNick = new JTextField(5);
		add(campoNick);
		campoIp = new JTextField(8);
		JLabel texto=new JLabel("CHAT");
		
		add(texto);
		add(campoIp);
		areaTexto = new JTextArea(12,20);
		add(areaTexto);
		campo1=new JTextField(20);
	
		add(campo1);		
		miboton=new JButton("Enviar");
		EnviaTexto mievento = new EnviaTexto();
		miboton.addActionListener(mievento);

		add(miboton);	
		Thread miHilo = new Thread(this);

		miHilo.start();
		
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(campo1.getText());
			try {
				Socket misocket = new Socket("localhost", 2019);
				//DataOutputStream salidaDatos = new DataOutputStream(misocket.getOutputStream());
				//salidaDatos.writeUTF(campo1.getText());
				//salidaDatos.close();
				
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(campoNick.getText());
				datos.setIp(campoIp.getText());
				datos.setMensaje(campo1.getText());
				
				/*if(misocket.getInetAddress().getHostName().equals("localhost") |misocket.getInetAddress().getHostName().equals("127.0.0.1")  ) {
					areaTexto.append("\n"+ datos.getMensaje());
					
				}*/
				
				ObjectOutputStream objetoDatos = new ObjectOutputStream(misocket.getOutputStream());
				objetoDatos.writeObject(datos);
				misocket.close();
							
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
		
	}		
	private JTextArea areaTexto;	
	private JTextField campo1,campoNick,campoIp;
	
	private JButton miboton;

	@Override
	public void run() {
		try {
			
			ServerSocket socketEscuchaCliente = new ServerSocket(1024);
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				cliente = socketEscuchaCliente.accept();
				ObjectInputStream objetoRecibido = new ObjectInputStream(cliente.getInputStream());
				paqueteRecibido = (PaqueteEnvio)objetoRecibido.readObject();
				areaTexto.append("\n" + paqueteRecibido.getNick() + " : "+ paqueteRecibido.getMensaje());
				cliente.close();
				objetoRecibido.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}



class PaqueteEnvio implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nick, ip, mensaje;

	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
	
}
