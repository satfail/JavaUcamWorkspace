package Excepciones;

import java.util.Scanner;

public class PruebaExcep {
	
	public static void main(String[] args) {
		int x = 5;
		int y = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un numero");
		int numero = entrada.nextInt();
		//Al introducir caracteres Excepcion
		
		
		
		int resultado = x/y; //Aqui no aparece error, ya que la sintaxis esta bien.
		//Las excepciones hacen un manejo de errores en ejecucion del programa
		//Aqui se para la ejecucion del programa, cuando encuentra la excepcion
		System.out.println("El resultado es = " + resultado);
	}

}
