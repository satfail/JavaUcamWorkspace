package ClasesyObjetos;
import java.util.Scanner;

public class TestFecha2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca la fecha con el siguiente formato dd/mm/aa : ");
		String sFecha = scanner.next();
		Private_public_get_set f = new Private_public_get_set(sFecha);
		System.out.println("La fecha es "+f);
		System.out.print("Introduzca los dias que quiera sumar o restar : ");
		int diasSum = scanner.nextInt();
		f.addDias(diasSum);
		System.out.println("Sumando "+diasSum+" dias a la fecha "+sFecha+ " que contiene "+f.fechaToDias()+ " resultan : "+f);
		
		
	}

}
