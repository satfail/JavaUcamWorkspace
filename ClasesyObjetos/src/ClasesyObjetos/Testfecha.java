package ClasesyObjetos;

import java.util.Scanner;

public class Testfecha {

	
	public static void main(String[] args) {
		
		Private_public_get_set fecha = new Private_public_get_set(); ///Por eso son importante los nombre de las clases cateto
		// el new instancia el objeto, no vale solo con declarar, se define un puntero que apunta a null al declararlo sin new
		// cuando le damos el new le asignamos la posición de memoria
		//System.out.println(fecha);
		fecha.setDia(2);
		fecha.setMes(10);
		fecha.setAnio(1970);
		System.out.println("Dia "+fecha.getDia());
		System.out.println("Mes "+fecha.getMes());
		System.out.println("Anio "+fecha.getAnio());
		System.out.println(fecha);
		

		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca el dia : ");
		int dia = scanner.nextInt();
		System.out.print("Introduzca el mes : ");
		int mes = scanner.nextInt();
		System.out.print("Introduzca el año : ");
		int anio = scanner.nextInt();
		Private_public_get_set fecha2 = new Private_public_get_set(dia, mes ,anio);
		System.out.println("Dia "+fecha2.getDia());
		System.out.println("Mes "+fecha2.getMes());
		System.out.println("Anio "+fecha2.getAnio());
		System.out.println(fecha2);
		System.out.println(fecha.equals(fecha2));
		String fecha3 = scanner.next();
		System.out.println(fecha3);
	}
}
