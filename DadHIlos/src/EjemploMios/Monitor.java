package EjemploMios;

public class Monitor{
	
	private boolean flag = true;

	


	public synchronized void darVuelta(int numero, String nombre, int velocidad) {
		
		System.out.println(numero+ " :  " + nombre +  " Salida || ");
		
		float tiempo = 500 *velocidad;

			try {
				Thread.sleep(500*velocidad);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		System.out.println(nombre + " " + " acabo la carrera  en " + tiempo/1000 + " segundos");
		flag = false;
		notifyAll();
	}
	
	public synchronized void darOtravuelta(int numero, String nombre, int velocidad) throws InterruptedException {
		while(flag) {
			wait();
		}
		
		darVuelta(numero,nombre,velocidad);
	}
	
	
	
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
