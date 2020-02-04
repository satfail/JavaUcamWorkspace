package EjemploMios;

public class mainCarrera {

	 public static void main(String[] args) {
		 
		 Monitor m = new Monitor();
		 Corredor c1 = new Corredor("Miguel", 1, 13,m);
		 Corredor c2 = new Corredor("Lucas", 2, 15,m);
		 Corredor c3 = new Corredor("Carmen", 3, 10,m);
		 Corredordos cdos1 = new Corredordos("Mj", 33, 5,m);
		 try {
			 c1.t.join();
			 c2.t.join();
			 c3.t.join();
			 cdos1.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
