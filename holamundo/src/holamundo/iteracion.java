package holamundo;
import java.util.Scanner;

public class iteracion {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Introduce el valor maximo de iteraciones");
	int v = scanner.nextInt();
	int i = 1;
	
	while ( i <= v )
	{
		System.out.println(i);
		i++;
	}
	

	
	do {
		
		System.out.println(i);
		i--;
		
	}while( i >= 1 );
	
	
	for ( i=1 ; i<=v ; i++) {
		System.out.println(i);
	}
	
	
	
}
}
