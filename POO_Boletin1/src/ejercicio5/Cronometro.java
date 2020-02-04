package ejercicio5;

public class Cronometro {
	private static final int N = 1000;

	public int nxnxn() {
		int suma =0;
		for(int i = 0 ;  i < N; i++) {
			for(int j = 0 ;  j < N; j++) {
				for( int k =0 ; k < N; k++) {
					suma += i+k +j;
				}
			}
		}
		return suma;
	}
	
	public long inicio() {
		long inicio =  System.currentTimeMillis();
		return inicio;
		
	}
	
	public long fin() {
		long fin =  System.currentTimeMillis();
		return fin;
		
	}
	public static void main(String[] args) {
		Cronometro crono = new Cronometro();
		
		long inicio = crono.inicio();
		
		crono.nxnxn();
		
		long fin = crono.fin();
		System.out.println("Milisegundos : " + (fin - inicio));
		
	}
}
