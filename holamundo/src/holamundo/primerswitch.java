package holamundo;

import java.util.Scanner;

public class primerswitch {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Introduzca el número del día de la semana: ");
	int v = scanner.nextInt();
	String dia;
	
	switch( v )
	{
	case 1:
		dia="Lunes";
		break;
	case 2:
		dia="Martes";
		break;
	case 3:
		dia="Miercoles";
		break;
	case 4:
		dia="Jueves";
		break;
	case 5:
		dia="Viernes";
		break;
	case 6:
		dia="Sábado";
		break;
	case 7:
		dia="Domingo";
		break;
	default:
		dia="Numero introducido incorrecto";
		break;
	
	}
	
	System.out.println("El día de la semana " + v + " es " + dia);
	
	
}
}
