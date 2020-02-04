package Paralelismo;
import java.awt.*;
import java.awt.event.*;


//Con esta demostracion vemos que si no separamos en un Thread la ejecucion de lo que realiza el boton
// La ventana parecerá congelada hasta que se termine la ejecucion lineal que realiza el boton
public class VentanaDemora extends Frame {
	
	private Button boton;
	private Choice combo;
	
	public VentanaDemora() {
		
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
			
			try {
				Thread.sleep(10000);		
				System.out.println("Termino la espera...!");
				
			}
			catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public static void main(String[] args) {
		new VentanaDemora();
	}
}
