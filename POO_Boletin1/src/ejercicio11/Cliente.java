package ejercicio11;

public class Cliente extends Persona {

	private int cif;

	public Cliente(String nombre, String apellido, String direccion, int cif) {
		super(nombre, apellido, direccion);
		this.cif = cif;
	}

	public int getCif() {
		return cif;
	}
	
	
	
}
