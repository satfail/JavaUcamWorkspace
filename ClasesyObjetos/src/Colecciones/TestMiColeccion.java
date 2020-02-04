package Colecciones;

import java.util.Scanner;

public class TestMiColeccion {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MiColeccion mc = new MiColeccion(5);
		System.out.println("Ingrese Nombre : ");
		String nom = scanner.next();
		
		
		while(!nom.equals("FIN")) { //Hasta meter FIN
			mc.insertar(nom, 0); //Metemos en la posicion 0
			nom = scanner.next();
		}
		
		String aux;
		
		for (int i = 0; i < mc.cantidad(); i++) { // Notese que mete siempre en la pos 0 
												  // por lo tanto va moviendo los datos a la derecha
												  // por eso aparecen en orden inverso.
			
			aux = (String) mc.obtener(i); ///Hay que castearlo por que devuelven tipo Object
			System.out.println(aux + " - " + aux.length()+ " caracteres"); 
		}
	}
}
