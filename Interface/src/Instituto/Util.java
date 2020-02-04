package Instituto;
import Comparable.Criterio;

public class Util {
	
	
	@SuppressWarnings ("unchecked")
	public static void ordenar(Comparable arr[]) { ///El array es tipo Comparable, por lo tanto da igual el tipo de dato de donde venga el array
		
		boolean ordenado = false; // para entrar la primera vez
		
		while(!ordenado) {
			
			ordenado = true; //si itero sin hacer nada sale
			for( int i = 0; i < arr.length-1 ; i++) { //Empiezp bucle
				
				if (arr[i+1].compareTo(arr[i]) < 0) { //Si me sale valor menor es que i+1 va detras
													  // Condicion de parada aqui ya no hay valores menores queda true y sale
					Comparable aux = arr [i];
					arr[i] = arr[i+1];
					arr[i+1] = aux;
					ordenado = false;
				}
			}
			
		}
		
	}
	
	public static void ordenar2 (Object arr[] , Criterio cr) {
		
		boolean ordenado = false;
		while(!ordenado) {
			
			ordenado = true ; 
			for( int i=0; i < arr.length -1; i++) {
				
				if(cr.comparar(arr[i+1], arr[i]) < 0) { //Ahora utilizo la clase absracta para comparar recibiendo el criterio desde main
					
					Object aux = arr [i];
					arr[i] = arr[i+1];
					arr[i+1] = aux;
					ordenado = false;
				}
			}
			
		}
		
	}
	
	public static void imprimir( Object arr[]) {
		
		for(int i = 0; i < arr.length ; i++) {
			
			System.out.println(arr[i]);
		}
			
	}

}
