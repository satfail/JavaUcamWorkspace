package Ejercicio3;

public class Cliente extends Persona{
	
	private int puntos;

	public Cliente(String nombre, int edad, int puntos) {
		super(nombre, edad);
		this.puntos = puntos;
	}

	public int getPuntos() {
		return puntos;
	}

	public String toString() {
		
			return super.toString() + " puntos = " + puntos; 
	}
	
	

}
