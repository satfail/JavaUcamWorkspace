package Genericas;

import java.util.Scanner;

public class TestGenericas {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca nombre : ");
		String nom = scanner.next();
		
		MiColeccion<String> mc = new MiColeccion<String>(3);
		
		while(!nom.equals("FIN")) {
			
			mc.agregar(nom);
			nom = scanner.next();
			
		}
		
		String aux;
		for( int i = 0 ; i < mc.cantidad() ; i++) {
			
			aux = mc.obtener(i);
			System.out.println(aux + " - "+ aux.length()+ " caracteres");
		}
	}

}
