package EjemploClases;

public class Principal {
	
	public Principal() {}
	
	private void launch() {
		Hilo hilo = new Hilo("Primero",1000);
		hilo.start();
		
		hilo = new Hilo("Segundo", 1500);
		hilo.start();
		
		System.out.println("Fin de m�todo launch");
	}
	
	
	public static void main(String args[]){
		Principal ejemploHilo = new Principal();
		
		ejemploHilo.launch();
	}
}
