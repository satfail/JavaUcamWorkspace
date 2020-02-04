package Boletin1;

public class Hilos  implements Runnable{

	private int nHilos;
	private int contador;
	private int nVeces;
	Thread[] t;
	
	
	
	public Hilos(int nHilos, int nVeces) {
		super();
		this.nHilos = nHilos;
		this.nVeces = nVeces;
		t = new Thread[nHilos];
		for(int i =0; i < nHilos; i++) {
			t[i] = new Thread(this,("Hilo " + i));
			t[i].start();
			System.out.println(t[i].getName() + " creado");
	
		}
		
	}

	public  void sumaUno(int nVeces) {
		
		for(int i = 0; i <nVeces; i++) {
			this.contador++;
		}
		
	}
	
	public void run() {
		
		sumaUno(nVeces);
		try {
			System.out.println("El hilo " + Thread.currentThread() + " va por " + contador );
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public int getContador() {
		return contador;
	}
	
	public void espera() {
		
		for(int i = 0; i < nHilos;  i++ ) {
			
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}	
}
