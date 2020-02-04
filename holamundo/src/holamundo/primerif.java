package holamundo;

import java.util.Scanner;

public class primerif {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca un valor entero : ");
		int v = scanner.nextInt();
		int resto = v % 2;
		if (resto == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
		
		//Utilizando if in-line
		String mensaje = (resto == 0) ? "Es par" : "Es Impar";
		System.out.println(v+" "+mensaje);
		
	}

}
