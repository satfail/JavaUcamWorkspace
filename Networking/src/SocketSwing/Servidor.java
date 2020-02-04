package SocketSwing;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		Thread hilo = new Thread(this);
		hilo.start();
		}
	
	private	JTextArea areatexto;

	@Override
	public void run() {
		try {
			ServerSocket socketServidor = new ServerSocket(2019);
			String nick, ip, mensaje;
			PaqueteEnvio paqueteRecibido;
			
			///Detectar direccion ip
			while(true) {
				Socket miSocket = socketServidor.accept();
				//DataInputStream entradaDatos = new DataInputStream(miSocket.getInputStream());
				//areatexto.append("\n" + entradaDatos.readUTF());
				//entradaDatos.close();
				
				///Detectar direccion ip
				
				InetAddress ipCliente = miSocket.getInetAddress();
				System.out.println("Se ha conectado con " +  ipCliente);
				
				///Recibo del Cliente
				ObjectInputStream objetoRecibido = new ObjectInputStream(miSocket.getInputStream());
				paqueteRecibido = (PaqueteEnvio)objetoRecibido.readObject();
				nick = paqueteRecibido.getNick();
				ip = paqueteRecibido.getIp();
				mensaje = paqueteRecibido.getMensaje();
				areatexto.append("\n"+ nick + " : " + "Mensaje :  " + mensaje + " para : " + ip);
				miSocket.close();
				
				///Reenviar al cliente correspondiente
				Socket socketDestinatario = new Socket(ip,1024);
				ObjectOutputStream objetoEnviar = new ObjectOutputStream(socketDestinatario.getOutputStream());
				objetoEnviar.writeObject(paqueteRecibido);
				socketDestinatario.close();
				objetoEnviar.close();
				
			
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
