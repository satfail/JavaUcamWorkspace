package Ejercicios;
//Mezcla los dos arreglos en c
import java.util.Scanner;
public class ArreglosUno {
	
public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	int a[] = new int[10];
	int b[] = new int[10];
	int c[] = new int[20];
	
	System.out.println("Introduzca los dos arreglos");
	for( int i = 0; i < 10 ; i++) {
		System.out.println("A : ");
		a[i] = entrada.nextInt();
		System.out.println("B : ");
		b[i] = entrada.nextInt();
	}
	int j = 0;
	for( int i = 0; i < 10 ; i++ ) {
		
		c[j] = a[i];
		j++;
		c[j] = b[i];
		j++;
	}
	
	for( int i : c) {
		
		System.out.println("--" + i);
	}

}
}
