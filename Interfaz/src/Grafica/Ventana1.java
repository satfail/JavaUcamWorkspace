package Grafica;
import java.awt.*;

public class Ventana1 extends Frame {
	
	private Button b1,b2,b3;
	
	public Ventana1() {
		
		super("Esta es la Ventana 1");
		//El constructor recibe el titulo del padre de la ventana
		
		setLayout(new FlowLayout(FlowLayout.LEFT)); //Se define la salida de la ventana, con alineacion
		
		b1 = new Button("Boton 1");
		add(b1);
		b2 = new Button("Boton 2");
		add(b2);
		b3 = new Button("Boton 3");
		add(b3);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Ventana1 v1 = new Ventana1();
	}

}
