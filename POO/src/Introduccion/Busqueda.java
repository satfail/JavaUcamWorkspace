package Introduccion;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class Busqueda {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int a[],capacidad,dato,opcion;
		boolean flag = false; // Encuentro o no encuetro valor
		capacidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad del array : "));
		a = new int[capacidad];
		
		for(int i = 0 ; i < capacidad; i++) {
			
			System.out.println("Introduzca el numero :");
			a[i] = entrada.nextInt();
		}
 
		System.out.println("Introduzca la Busqueda : 1- Secuencial 2- Binaria");
		opcion = entrada.nextInt();
		dato = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero a buscar : "));
		
		if (opcion == 1) {
			int i = 0;
			while(i < capacidad && flag == false ) {
				
				if ( a[i] == dato) {
					flag = true;
				}
				i++;
			}
			
			if(flag == false)
				System.out.println("No hemos encotrado el dato");
			else
				// i-1 xk suma uno mas al final del bucle
				System.out.println("Dato "+ dato + " encontrado en la posicion " + (i-1));
		}
		//Tiene que estar en forma creciente ordenado si no nada
		if (opcion == 2) {
			int inferior, superior, mitad, i = 0;
			inferior = 0;
			superior = capacidad;
			mitad = (inferior+superior)/2;
			
			while(inferior <= superior && i < capacidad) {
				if (a[mitad] == dato) {
					flag = true;
					break;
				}
				if(a[mitad] > dato) {
					superior = mitad;
					mitad = (inferior+superior)/2;
				}
				
				if(a[mitad] < dato) {
					inferior = mitad;
					mitad = (inferior+superior)/2;
				}
				i++;
				
			}
			if(flag == false)
				System.out.println("No hemos encotrado el dato");
			else
				// esta en mitad, xk es la posicion que vamos actualizando para buscar
				System.out.println("Dato "+ dato + " encontrado en la posicion " + mitad);
			
		}
		
	}

}
