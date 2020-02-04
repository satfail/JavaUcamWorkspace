package Paralelismo;

public class DemoThread extends Thread { //Clases thread se extienden de thread

	private String nombre;
	public DemoThread(String nombre) {	//Cambio el Constructor
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
	public static void main(String[] args) {
		
		DemoThread t1 = new DemoThread("Lucas"); //Se crean 3 hilos
		DemoThread t2 = new DemoThread("Carmen");
		DemoThread t3 = new DemoThread("Maria Jose");
		
		t1.start(); //Start invoca al metodo run
		t2.start();
		t3.start(); 
		// Si invocamos run en vez de start la ejecucion sera lineal
	}
}
