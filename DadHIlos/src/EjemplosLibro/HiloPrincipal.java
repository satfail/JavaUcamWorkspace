package EjemplosLibro;

public class HiloPrincipal {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("El hilo acutal es " + t);
		
		t.setName("Soy Papi");
		
		System.out.println("El hilo principal se llama " + t); // Nombre, prioridad y de quien es su padre
		try {
			for (int n=5 ; n > 0 ; n--) {
				
				System.out.println(n);
				Thread.sleep(1000);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
