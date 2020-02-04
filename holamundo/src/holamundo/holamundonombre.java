package holamundo;
import java.util.Scanner;

public class holamundonombre {
	public static void main(String[] args) {
		
		//Esta clase permite lectura por teclado
		Scanner scanner = new Scanner(System.in);
		
		// Mensaje para el user
		System.out.print("Ingrese su nombre edad y altura: ");
		
		//leemos
		String nom = scanner.next();
		int edad = scanner.nextInt();
		double altura = scanner.nextDouble();
		
		
		//Mostramos
		System.out.println("Hola: " + nom + " Edad " + edad + " Altura " + altura);
		
		
	}

}
