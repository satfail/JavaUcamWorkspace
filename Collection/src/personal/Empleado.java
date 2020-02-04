package personal;

public class Empleado extends Persona{
	
	private float sueldo = 4000;

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String getDetalle() {
		// TODO Auto-generated method stub
		
		String cadena = " Sueldo: " + sueldo;
		
		return cadena;
	}

}
