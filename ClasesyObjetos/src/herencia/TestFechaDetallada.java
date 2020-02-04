package herencia;

import java.util.Scanner;

public class TestFechaDetallada {

	public static void main(String[] args) {
		//FechaDetallada f = new FechaDetallada("0/0/0"); ///Lo hereda de Private_public_get_set
		
		FechaDetallada f = new FechaDetallada(1,5,1986); 
		///f.setDia(1);
		//f.setMes(5);
		//f.setAnio(1986);
		System.out.println(f);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca los dias que quiere sumar a la fecha : ");
		int i = scanner.nextInt();
		f.addDias(i);
		System.out.println("La nueva fecha es " + f); ///Estamos accediendo a todo lo heredado y publico
		
		///Ejemplo de error ya que esa variable es privada
		//Los metodos suelen ser publicos y atributos privados
		//f.anio= 2001; 
		
		
		
	}
}
