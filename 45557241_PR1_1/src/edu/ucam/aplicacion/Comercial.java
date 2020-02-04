package edu.ucam.aplicacion;

public class Comercial extends Persona {
	private static final long serialVersionUID = 1L;
	private float sueldo;
	private int antiguedad;

	public Comercial(Persona p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	public Comercial(String nombre, String apellido, String dni, Automovil auto) {
		super(nombre, apellido, dni, auto);
		// TODO Auto-generated constructor stub
	}
	
	public Comercial (Comercial c) {
		this.antiguedad = c.getAntiguedad();
		this.sueldo = c.getSueldo();
		this.setNombre(c.getNombre());
		this.setApellido(c.getApellido());
		this.setDni(c.getDni());
		this.setAuto(c.getAuto());
		
	}
	
	public float getSueldo() {
		return sueldo;
	}
	@Override
	public String toString() {
		return super.toString() + getDetalle();
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	@Override
	public String getDetalle() {

		return "\t  Comercial :  Sueldo = " + getSueldo() + " Antiguendad " + getAntiguedad();
	}
	
	
	

}
