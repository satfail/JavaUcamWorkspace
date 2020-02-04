package EjemplosLibro;

public class HiloThread extends Thread {

	public HiloThread(String nombre) {
		
		this.setName(nombre);
	}
	public HiloThread() {
		super("HiloThread");
		System.out.println("Hilo hijo " +  this);
		this.start();
	}
	
	public void run() {
		
		try {
			
			for(int i = 0; i < 5; i ++) {
				
				System.out.println("Hilo hijo : "+ i);
				Thread.sleep(500);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hilo hijo cerrado");
	}

	public static void main(String[] args) {
		new HiloThread();
		try {
			
			for(int i = 0; i < 5; i++) {
				
				System.out.println("Hilo padre : "+ i);
				Thread.sleep(1000);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hilo ppl cerrado ");
	}
	
	
}
