package Introduccion;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class Arreglos {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int capacidad;
		
		capacidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad del array : "));
		
		char letras[] = new char[capacidad];
		System.out.println("Introduzca un caracter hasta llenar");
		
		for ( int i =0 ; i < capacidad ; i++) {
			
			System.out.println((i+1) + ". Introduzca otro caracter : ");
			letras[i] = entrada.next().charAt(0);
		}
		
		System.out.println("Los caracteres son :");
		
		for(int i = 0; i < letras.length; i++) {
			
			System.out.print("-" + letras[i]);
		}
		System.out.println("----------FOREACH---------");
		
		String nombre[] = {"Alejandro", "Maria", "Carmen", "Lucas"};
		
		for( String elementos : nombre)	{ 
			
			System.out.println(elementos);
		}
	}

}
