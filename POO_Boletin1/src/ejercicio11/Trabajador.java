package ejercicio11;

public class Trabajador extends Persona{

	private float salario;
	private int ccc;
	public Trabajador(String nombre, String apellido, String direccion,float salario, int ccc) {
		super(nombre, apellido, direccion);
		this.salario = salario;
		this.ccc = ccc;
	}
	public float getSalario() {
		return salario;
	}
	public int getCcc() {
		return ccc;
	}
	
	
	
	
}
