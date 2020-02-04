package Herencia;
//Forma de reutilizacion de software, en la que se crea una clase nueva que
//aborbe los mienbros de una clase existente
public class Persona {
	
	protected String nombre;
	private String apellidos;
	private int edad;
	
	
	public  Persona() {
		// TODO Auto-generated constructor stub
	};
	public Persona(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public Persona(String nombre){
		this(nombre,"hola",35);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	

}
