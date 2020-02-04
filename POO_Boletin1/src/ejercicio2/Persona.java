package ejercicio2;

public class Persona {
	
	private String nombre;
	private int anyoNacimiento;
	private String dni;
	private float altura;
	public Persona(String nombre, int anyoNacimiento, String dni, float altura) {
		this.nombre = nombre;
		this.anyoNacimiento = anyoNacimiento;
		this.dni = dni;
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}
	public String getDni() {
		return dni;
	}
	public float getAltura() {
		return altura;
	}
	
	public void cambiarNombre ( String nombre) {
		this.nombre = nombre;
	}
	
	public int calculaEdad(int anyo) {
		int edad;
		edad = anyo - this.getAnyoNacimiento();
		return edad;
	}
	
	
}
