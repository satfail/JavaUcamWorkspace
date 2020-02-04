package EjemploMios;

public class Corredordos extends Persona implements Runnable{

	Thread t;
	Monitor m;

	
	public Corredordos(String nombre, int numero, int velocidad, Monitor m) {
		super(nombre, numero, velocidad);
		t = new Thread(this);
		this.m = m;
		t.start();
	}
	

	public void run() {

		try {
			m.darOtravuelta(getNumero(), getNombre(), getVelocidad());
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
	}
	
	

	

}
