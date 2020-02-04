package EjemplosLibro;
// El comportamiento de la prioridad depende del SO
// dependiendo de si es apropiativo o no
public class HiloPrioridad implements Runnable{
	
	long click = 0;
	Thread t;
	private  volatile boolean running = true; //volatile variable compartida en los hilos
	//no son guardadas en el caché del procesador, es decir, toda lectura/escritura de la misma se realiza directamente contra la memoria principal.
	//GARANTIZAMOS QUE EL VALOR LEIDO POR LOS HILOS ES EL ULTIMO QUE HAY EN ELLA, no se ha copiado al cache aun
	
	public HiloPrioridad(int prioridad) {
		t = new Thread(this);
		t.setPriority(prioridad);
	}
	
	public void run() {
		
		while(running) //Mira el valor cada vez que hay una iteracion, 
			click++;
	}
	
	public void stop() {
		running = false;
	}
	
	public void start () {
		
		t.start();
	}
	
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY); //MAxima para hilo ppl
		HiloPrioridad h1 = new HiloPrioridad(Thread.NORM_PRIORITY +2);
		HiloPrioridad h2 = new HiloPrioridad(Thread.NORM_PRIORITY -2);
		
		h1.start();
		h2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h1.stop();
		h2.stop();
		
		try {
			h1.t.join();
			h2.t.join(); //Esperamos a que terminen los hijos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("H1 alta : " + h1.click);
		System.out.println("H2 alta : " + h2.click);
	}
}
