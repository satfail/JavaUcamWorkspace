package EjemploClases;

public class Hilo extends Thread{

	private String name = "";
	private int milis = 2000;
	
	public Hilo(String name, int milis){
		this.name = name;
		this.milis = milis;
	}
	
	public void run(){
		
		try {
			while(true){
				System.out.println(this.name + " ejecutado");				//Se abren dos hilos y quedan todo el rato poniendo estos mensajes
				Thread.sleep(this.milis);				
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
