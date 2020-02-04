package Paralelismo;

public class DemoRunnable implements Runnable { //En runnable tenemos la clase thread que crea ñps hilos
	
	private String nombre;
	public DemoRunnable(String nombre) {	//Cambio el Constructor
		this.nombre = nombre;	
	}

	public void run() { //heredan de run, lo sobreescribo
		
		try {  //Calcula Tiempo random para cada thread y muestro un nombre
			
			int x = (int)(Math.random()*5000); 
			Thread.sleep(x);
			System.out.println("Soy " + nombre + "(" + x + ")");
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread (new DemoRunnable("Lucas")); //Creamos 3 thread a los que pasamos 3 instanciancias Runnable
		Thread t2 = new Thread (new DemoRunnable("Carmen"));
		Thread t3 = new Thread(new DemoRunnable("Maria Jose"));
		
		t1.start(); //Start invoca al metodo run
		t2.start();
		t3.start(); 
		// Esta parte duerme y sigue el programa, para esperar a que esto termine y siga la ejecucion secuencial
		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final del Programa !!!");
	}

}
