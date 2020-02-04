package Ejercicio5;

public class Coche extends Vehiculo{
	
	public int numPlazas;

	public Coche(int potencia, int numPlazas) {
		super(potencia);
		this.numPlazas = numPlazas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}
	
	
	
	

}
