package EjemplosLibro;

//Cuando hay un recurso sincronizado, solo un hilo puede hacer uso de el, el resto se bloquean
// hasta que el hilo ejecutor suelta ese recurso

public class HiloSincro  {
	
	synchronized void call(String msg) {
		
		System.out.println(" [ " + msg);
		try {
			
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ] ");
	}
	
}

class Caller implements Runnable{
	
	String msg;
	HiloSincro target;
	Thread t;
	
	public Caller(HiloSincro target, String s) {
		
		this.target = target;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		/*synchronized (target) {
			target.call(msg);
		}*/ 
		//Si no quiero hacer la funcion sincronizada de por si, para no generalizar
		target.call(msg);
	}
	
	public static void main(String[] args) {
		HiloSincro target = new HiloSincro();
		Caller c1 = new Caller(target, "Hola");
		Caller c2 = new Caller(target, "Sincronizado");
		Caller c3 = new Caller(target, "Mundo");
		
		try {
			
			c1.t.join();
			c2.t.join();
			c3.t.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("FIN");
	}
}


	
