package Introduccion;

import javax.swing.JOptionPane;

public class Condicionales {
	
	public static void main(String[] args) {
		
		int numero, dato = 5;
		boolean verdad = true;
		
		while(verdad) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero : "));
			if ( numero == dato) {
				JOptionPane.showMessageDialog(null, "Es 5");
				verdad = false;
			}
			else
			JOptionPane.showMessageDialog(null, "No es el numero correcto");
		
			int dato2;
			dato2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero entre 1 y 5 : "));
			
			switch(dato2) {
			
				case 1: JOptionPane.showMessageDialog(null, "1");
						break;
				case 2: JOptionPane.showMessageDialog(null, "2");
					break;
				case 3: JOptionPane.showMessageDialog(null, "3");
					break;
				case 4: JOptionPane.showMessageDialog(null, "4");
					break;
				case 5: JOptionPane.showMessageDialog(null, "5");
					break;
				default: JOptionPane.showMessageDialog(null, "Numero Incorrecto");
					break;
				
			}
			
			System.out.println(dato <= dato2 ? "El primer numero es menor o igual que el segundo " : "El primer numero es mayor que el segundo");
		
		
		
		
		}	
	}
}
