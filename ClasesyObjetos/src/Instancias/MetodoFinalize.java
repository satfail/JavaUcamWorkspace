package Instancias;

public class MetodoFinalize {
	
	private static int cont = 0 ;
	
	public MetodoFinalize() {
		
		cont++;
		System.out.println(cont);
	}
	
	public void finalize() {
		
		cont--; //Cuando libera memoria quita un objeto del contador.
	}

	
	public static void main(String[] args) {
		while ( true ) {
			
			new MetodoFinalize();
		}
	}
}


