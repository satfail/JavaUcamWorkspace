package EquipoFutbol;

public class Medico  extends Persona{

	private String titulacion;
	private int exp;
	public Medico(String nombre, String apellidos, int edad, String titulacion, int exp) {
		super(nombre, apellidos, edad);
		this.titulacion = titulacion;
		this.exp = exp;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	@Override
	public void partidoFutbol() {
		System.out.println("El medico asiste en el partido " + titulacion);
	}
	
	@Override
	public void entrenamiento() {
		
		System.out.println("El medico asiste en el entrenamiento ");
	}
	
	public void curarLesion() {
		
		System.out.println("Lesion curada ");
	}
}
