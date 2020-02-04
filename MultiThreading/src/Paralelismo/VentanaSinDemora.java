package Paralelismo;

import java.awt.*;
import java.awt.event.*;


public class VentanaSinDemora extends Frame {
	
	private Button boton;
	private Choice combo;
	
	public VentanaSinDemora() {
		
		setLayout(new FlowLayout());
		add(boton = new Button ("Esto va a demorar..."));
		boton.addActionListener(new EscuchaBoton()); //Acion que va a realizar el boton
		
		add ( combo = new Choice() );	//boton tipo choice, con lista de elementos
		combo.addItem("Item 1");
		combo.addItem("Item 2");
		combo.addItem("Item 3");
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener{
		
		public void actionPerformed (ActionEvent e) {		//Lo que hacemos al pulsar el boton
			
			boton.setEnabled(false);
			TareaBoton t = new TareaBoton(); //Creo un Thread para la accion del boton
			t.start();	//Abro el Thread
		}
	}
	
	class TareaBoton extends Thread{
		
		public void run() { //Hacemos lo que hariamos en el ActionPerformed
			
			try {
				
				Thread.sleep(10000);
				System.out.println("Termino la espera....!");
				boton.setEnabled(true);
			}
			catch(Exception ex) {
				
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
public static void main(String[] args) {
	new VentanaSinDemora();
}
}
