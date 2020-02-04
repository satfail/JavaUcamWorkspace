package Introduccion;

import javax.swing.JOptionPane;

public class EntradaSalidaJoptionPane {

	public static void main(String[] args) {
		String cadena;
		int entero;
		char letra;
		double decimal;
		
		cadena = JOptionPane.showInputDialog("Escribe una cadena : ");
		entero = Integer.parseInt(JOptionPane.showInputDialog("Escribe un entero : "));
		letra = JOptionPane.showInputDialog("Escribe un caracter : ").charAt(0);
		decimal =  Double.parseDouble(JOptionPane.showInputDialog("Escribe un decimal : "));
		JOptionPane.showMessageDialog(null, cadena + " " + entero + " " + letra + " " + decimal);
	}
}
