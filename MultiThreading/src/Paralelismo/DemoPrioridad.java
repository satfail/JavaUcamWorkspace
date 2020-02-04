package Paralelismo;

public class DemoPrioridad {
	
	public static void main(String[] args) {
		
		MiThred t1 = new MiThred("Carmen");
		MiThred t2 = new MiThred("Lucas");
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		t1.start();
		t2.start(); ///Deberia terminar primero t1 y luego t2, es por el procesador?
		
	}
	
	static class MiThred extends Thread {
		
		String nom;
		public MiThred(String nom) {
			
			this.nom = nom;
		}
		
		public void run() {
			
			for( int i = 0; i < 5 ; i++) {
				
				System.out.println(nom + " - " + i);
				yield(); //Para y cede al otro thread
			}
		}
	}

}
