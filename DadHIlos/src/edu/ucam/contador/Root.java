package edu.ucam.contador;

public class Root {

	public static void main(String[] args) {
		Contador contador = new Contador();
		
		
		
		try {
			
			HiloContador hiloContador = null;
			for (int i = 0 ; i < 15000 ; i++){
				hiloContador = new HiloContador(contador);
				hiloContador.start();
			}
			
			hiloContador.join();

			
			System.out.println(contador.getEstado());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
