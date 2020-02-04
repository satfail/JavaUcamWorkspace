package Boletin1;

public class Principal {
	
	public static void main(String[] args) {
		
		int nHilos = Integer.parseInt(args[0]);
		int nVeces =  Integer.parseInt(args[1]);
		Hilos cincoHilos = new Hilos(nHilos, nVeces);
		cincoHilos.espera(); //Para que el hilo ppl espere a los hilos generados
		System.out.println( "Total =" + cincoHilos.getContador()); 
	}

}
