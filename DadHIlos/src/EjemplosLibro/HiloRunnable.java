package EjemplosLibro;

public class HiloRunnable implements Runnable{

	Thread t;
	
	public HiloRunnable() {
		t = new Thread(this, "Hilo Runnable");
		System.out.println("Hilo hijo creado " + t);
		t.start();
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
		new HiloRunnable();
		
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
