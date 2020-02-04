package Sobreescritura;

public class Principal {

	public static void main(String[] args) {
		Persona p = new Persona();
		Perro d = new Perro();
		Vaca v = new Vaca();
		
		
		p.comer();//Sale el sobreescrito	
		d.comer();//Sale el que esta sobreescrito
		v.comer();//Sale el de animal porque no esta sobreescrito
	}
	
	
}
