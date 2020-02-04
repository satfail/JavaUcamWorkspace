package EquipoFutbol;

public class Futbolista extends Persona{
	
	private int dorsal;
	private String posicion;
	
	public Futbolista(String nombre, String apellidos, int edad, int dorsal, String posicion) {
		super(nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	@Override
	public void partidoFutbol() {
		System.out.println("El futbolista juega el partido en la posicion " + posicion);
	}
	
	@Override
	public void entrenamiento() {
		
		System.out.println("El futbolista esta entrenado ");
	}
	
	public void entrevista() {
		
		System.out.println("El futbolista esta dando una entrevista ");
	}
	
	
	
	

}
