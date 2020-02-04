package Ejercicios;

import java.util.Scanner;
public class InsertarOrdenado {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int a[] = new int[10];
		boolean flag = true;
		int numero, j= 0;
		System.out.println("Introduzca los numeros ordenados de forma creciente : ");
		
		do {
			
			for (int i= 0; i < 5; i++) {
				
				System.out.println("Introduzca el numero :");
				a[i] = entrada.nextInt();
			}
			for ( int i = 0; i < 4; i++) {
				if(a[i] < a[i+1]) {
					flag=false;
				}
			}
			if (flag == true)
				System.out.println("No ordenado");
		}while(flag);
		
		System.out.println("Inserte uno mas :");
		numero = entrada.nextInt();
		
		for (int  i = 0; a[i] < numero ; i++)
			j++; //Donde voy a insertar
		
		//Movemos al arreglo a los numeros que van detras de donde inserto
		
		for ( int i = 4 ; i >= j ; i--)
			a[i+1] = a[i];
		
		a[j] = numero;
		
		for (int i : a) {
			
			System.out.println("--"+i);
		}

	}
}