package EjemplosLibro;

public class HiloParada implements Runnable {

	private String nombre;
	private Thread t;
	public HiloParada(String nombre) {
		this.nombre = nombre;
		t = new Thread(this, nombre);
		t.start();
	}
	
	public void run() {
		
		try {
			
			for(int i = 0; i < 5; i ++) {
				
				System.out.println(nombre +" : "+ i);
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nombre + " cerrado");
	}
	
	public static void main(String[] args) {
		
		HiloParada h1 = new HiloParada("Uno");
		HiloParada h2 = new HiloParada("Dos");
		HiloParada h3 = new HiloParada("Tres");
		System.out.println(h1 + " Esta vivo: " + h1.t.isAlive()); //Accedo porque es privado de esta clase!!!
		System.out.println(h2 + " Esta vivo: " + h2.t.isAlive()); // Si lo hago fuera necesito getThread
		System.out.println(h3+ " Esta vivo: " + h3.t.isAlive());
		
		System.out.println("Esperamos a que todos finalicen");
	//try {
			//h1.t.join(); 
		//	h2.t.join(); // Los hilos esperan a que termine de donde nacen , en este caso el principal
		//	h3.t.join();
			
	//	} catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
		System.out.println(h1 + " Esta vivo: " + h1.t.isAlive()); 
		System.out.println(h2 + " Esta vivo: " + h2.t.isAlive());
		System.out.println(h3+ " Esta vivo: " + h3.t.isAlive());
		System.out.println("Salida del hilo principal ");
	
	}
	
	
}
