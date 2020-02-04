package holamundo;

import java.util.Scanner;

public class matriz {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca el numero de filas de la matriz : ");
		int n = scanner.nextInt();
		System.out.print("Introduzca el numero de columnas de la matriz : ");
		int m = scanner.nextInt();
		int matriz[][] = new int[n][m];
		int random;
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int j = 0 ; j < m ; j++) {
				
				random = (int) (Math.random()*1000);
				matriz[i][j] = random;
				
			}
		}
		
		for (int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++)
				System.out.print(matriz[i][j] + "\t");
			System.out.println();
		}
		
	}

}
