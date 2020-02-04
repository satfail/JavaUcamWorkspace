package Ejercicio3;

import java.util.Scanner;

//En sencillo no implemento correcion de errores, demuestro polimorfismo


public class Principal {
	
	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduzca el numero de personas : ");
		int max = entrada.nextInt();
		Persona [] lista1 = new Persona[max];
		for (int i = 0; i < max; i++) {
			System.out.println("Introduzca Cliente/Empleado (1/2)");
			if(entrada.nextInt() == 1) {
				lista1[i] = new Cliente("Cliente", 33, 100);
			}
			else {
				lista1[i] = new Empleados("Empleado", 20, 1900);
				
			}
		}
		
		Empresa e1 = new Empresa("UCAM", lista1);
		e1.mostrarPersonas();
		
		entrada.close();
	}
	
	

}
