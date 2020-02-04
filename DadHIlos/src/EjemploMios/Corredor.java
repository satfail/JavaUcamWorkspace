package EjemploMios;

public class Corredor extends Persona implements Runnable{
	
	Thread t;
	Monitor m ;
	public Corredor(String nombre, int numero, int velocidad, Monitor m) {
		super(nombre, numero, velocidad);
		this.m = m;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		
		m.darVuelta(getNumero(), getNombre(), getVelocidad());
	}
	


}
