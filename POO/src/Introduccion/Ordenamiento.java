package Introduccion;

import java.util.Scanner;

import javax.swing.JOptionPane;
public class Ordenamiento {

	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int a[], capacidad ,opcion, aux;
		
		
		capacidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la capacidad "));
		a = new int[capacidad];
		
		for(int i = 0 ; i < capacidad; i++) {
			
			System.out.println("Introduzca el numero :");
			a[i] = entrada.nextInt();
		}
		
		System.out.println("Introduzca la Ordenacion -1 Burbuja(Seleccion Directa en Udemy) -2 InDirec");
		opcion = entrada.nextInt();
		
		//Burbuja
		if (opcion == 1) {
			for(int i = 0; i < (capacidad -1 ) ; i++) { //Fijo la posicion i 
				for(int j = i+1 ; j <  (capacidad ); j++) {//Itero en la j desde i
					
					if(a[j] < a[i]) { //Compruebo
						
						aux = a[j]; //Cambio
						a[j] = a[i];
						a[i] = aux;
					}
					
				}
				
			}
		}
		
		//Inserccion Directa cada vez que hay cambio comprobamos mas a la izq para
		//seguir cambiando
		//Apuntes de Algoritmia 1º con dos bucles for, es lo mismo
		if (opcion == 2) {
			int pos;
			for (int i = 0 ; i < (capacidad); i++) {
				pos = i; //Fijo en i
				aux = a[i]; //Cojo el valor
				while((pos > 0) && (a[pos-1] > aux)) { //Hata que llegue a la primera y el valor de la posicion anterior se mayor
					
					a[pos] = a[pos -1]; //Voy cambiando
					pos--; //Hasta que llegue a pos 1
				}
				a[pos] = aux; //Coloco el ultimo valor
			}
		}
		
		
		for (int i : a) {
			System.out.println("--"+ i);
		}
	}
}
