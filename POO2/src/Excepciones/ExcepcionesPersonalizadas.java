package Excepciones;

import java.util.Scanner;

public class ExcepcionesPersonalizadas {
	
	private int num;
	private Scanner entrada = new Scanner(System.in);
	
	public void introducirNumero() throws Excepcion0{
		
		do {
			
			
			System.out.println("Introduzca un numero. 0 para salir");
			this.num = entrada.nextInt();
			if (this.num == 0) 	
				throw new Excepcion0();
				
			
			
		}while(this.num != 0);
		
	}
	
	public static void main(String[] args) {
		
		ExcepcionesPersonalizadas prueba = new ExcepcionesPersonalizadas();
		try {
			prueba.introducirNumero();
		}
		catch (Excepcion0 e) {
			System.out.println("Adios");
		}
	}

}
