package holamundo;

import java.util.Scanner;

public class primerarray {

	public static void main(String[] args) {
		//array
		int array[] = new int[10];
		Scanner scanner = new Scanner(System.in); //System.input
		
		System.out.print(" Introduzca un valor >=0 : ");
		int v = scanner.nextInt();
		int i = 0;
		while(v >= 0 && i < 10 ) {
			array[i++] = v ;
			System.out.print("Ingrese el siguiente valor : ");
			v = scanner.nextInt();

			
		}
		
		for(i=0 ; i<10 ; i++) {
			
			System.out.println(array[i]);
		}
		System.out.println("El array tiene " + array.length + " elementos");
	} 
	
}
