package Genericas;

import java.util.Scanner;

public class TestCola {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		MiCola<String> c = new MiCola<String>();
		
		String nom = scanner.next();
		
		while(!nom.equals("FIN")) {
			
			c.encolar(nom);
			nom = scanner.next();
		}
		
		nom ="si";
		
		do {
			System.out.println("Desea eliminar de la cola? ");
			nom = scanner.next();
			System.out.println(c.desencolar());
		}while(!nom.equals("no"));
		
		
	}

}
