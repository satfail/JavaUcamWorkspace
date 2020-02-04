package EjemploProductorConsumidor;

public class Productor extends Thread {

	private Monitor buff;
	private int n;
	private int sleep;
	
	public Productor ( Monitor b, int n, int s) { //Recibe instancia Monitor( array con su capacidad)
												  // n es la cantidad de caracteres que queremos producir y s el tiempo que duerme el Thread
		this.buff = b;
		this.n = n;
		this.sleep = s;
		
	}
	
	public void run () {
		try {
			
			char c;
			for (int i = 0; i < n ;i++) {
				
				c = (char) ('A' + i);
				buff.poner(c);
				System.out.println("Se ha PRODUCIDO el caracter : " + c );
				sleep( (int) (Math.random()*sleep));
				
			}
			
		}
		
		catch(Exception ex){
			
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
