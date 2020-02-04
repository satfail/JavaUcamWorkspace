package edu.ucam.aplicacion;

public class Jefe extends Persona {
	
	private static final long serialVersionUID = 1L;
	private float sueldo;
	private float antiguedad;
	public Jefe() {
		super();
	}

	public Jefe(String nombre, String apellido, String dni, Automovil auto) {
		super(nombre, apellido, dni, auto);
	}

	public Jefe(String nombre, String apellido, String dni, Automovil auto, float sueldo, float antiguedad) {
		super(nombre, apellido, dni, auto);
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
	}
	
	public Jefe(Jefe j) {
		
		this.antiguedad = j.getAntiguedad();
		this.sueldo = j.getSueldo();
		this.setNombre(j.getNombre());
		this.setApellido(j.getApellido());
		this.setDni(j.getDni());
		this.setAuto(j.getAuto());
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public float getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(float antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return super.toString() + getDetalle();
	}

	@Override
	public String getDetalle() {
		// TODO Auto-generated method stub
		return "\tJefe:  Sueldo = " + getSueldo() + " Antiguendad " + getAntiguedad();
	}
	
	
	
	

}
