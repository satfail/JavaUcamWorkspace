package Paralelismo;

public class DemoYield {
	
	public static void main(String[] args) {
		
		MiThred t1 = new MiThred("Lucas");
		MiThred t2 = new MiThred("Carmen");
		
		
		t1.start();
		t2.start();
		
		
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
