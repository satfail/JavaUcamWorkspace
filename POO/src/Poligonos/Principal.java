package Poligonos;
import java.util.ArrayList;
import java.util.Scanner;
//Con arreglo dinamico
public class Principal {
	//Para esta clase static
	static ArrayList<Poligono> polis = new ArrayList<Poligono>();
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		llenarPoligono();
		mostrarResultados();

		
	}
	
	public static void llenarPoligono() {
		int opcion;
		boolean flag = true;
		char respuesta;
		do {
			do {
				System.out.println("Introduzca que tipo de poligono va introducir");
				System.out.println("1- Triangulo");
				System.out.println("2- Rectangulo");
				System.out.print("Opcion : ");
				opcion = entrada.nextInt();
			}while(opcion < 1 || opcion >2);
			System.out.println();
			switch(opcion){
			
			case 1: llenarTriangulo();
				break;
			
			case 2: llenarRectangulo();
				break;
				
				
			}
			
		System.out.print("Desea Introducir otro poligono? (y/n) : ");
		respuesta = entrada.next().charAt(0);
		if (respuesta == 'n' || respuesta == 'N')
			flag = false;
		
		}while(flag);
		
	}
	
	public static void llenarTriangulo() {
		double l1, l2 , l3;
		
		System.out.print("Introduzca el Lado1 ");
		l1 = entrada.nextDouble();
		System.out.print("Introduzca el Lado2 ");
		l2 = entrada.nextDouble();
		System.out.print("Introduzca el Lado3 ");
		l3 = entrada.nextDouble();
		
		Triangulo trig = new Triangulo(l1,l2,l3);
		//Guardamos el triangulo en el arreglo Polimorfismo
		polis.add(trig);
	}
	
	
	public static void llenarRectangulo() {
		double l1, l2;
		
		System.out.print("Introduzca el Lado1 ");
		l1 = entrada.nextDouble();
		System.out.print("Introduzca el Lado2 ");
		l2 = entrada.nextDouble();

		
		Rectangulo rec = new Rectangulo(l1,l2);
		//Guardamos el triangulo en el arreglo Polimorfismo
		polis.add(rec);
	}
	
	public static void mostrarResultados() {
		
		for(Poligono poli : polis) { // For varible aux IN array de elementos
			
			System.out.println(poli.toString());
			System.out.println("Area = " +  poli.area());
		}
	}
	
	
}
