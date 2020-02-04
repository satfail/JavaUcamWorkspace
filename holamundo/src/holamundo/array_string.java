package holamundo;

import java.util.Scanner;

public class array_string {

	public static void main(String[] args) {
		String dias[] = { "Lunes" , "Martes", " Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un dia de la semana : ");
		int v = scanner.nextInt();
		if(v <= dias.length)
			System.out.println(dias[v-1]);
		else
			System.out.println("Dia incorrecto ");
		
		}
	}

