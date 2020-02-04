package EjemplosLibro;

public class TresHilos implements Runnable {

	private String nombre;
	Thread t;
	public TresHilos() {}
	public TresHilos(String nombre) {
		
		this.nombre = nombre;
		t = new Thread(this,nombre);
		System.out.println("Nuevo hilo ID : " + t );
		t.start();
	}
	public void run() {
			
			try {
				
				for(int i = 0; i < 5; i ++) {
					
					System.out.println(nombre +" : "+ i);
					Thread.sleep(1000);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(nombre + " cerrado");
		}
	public static void main(String[] args) {
		
		new TresHilos("Uno");
		new TresHilos("Dos");
		new TresHilos("Tres");
		TresHilos hilo = new TresHilos();
		hilo.run(); // No deja cambiar nombre solo metodo run
		
		HiloThread hilo2 = new HiloThread("Voy comprendiendo");
		hilo2.start();
		
		
		try {
			Thread.sleep(10000); //Para el principal para que terminen los hijos
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
