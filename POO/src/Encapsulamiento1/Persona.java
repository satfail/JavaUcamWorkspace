package Encapsulamiento1;
//El encapsulamiento es hacer los datos privados para que no se puedan mofificar
//desde clases que van a heredar. Los metodos accesores son metodos para poder 
//asignar valores a nuestros objetos, son los setters y getters
public class Persona {
	private final String dni;
	private String nombre;
	private int edad;
	
	public Persona() {  //La sobrecarga del constructor sin parametros
						//tiene que tener un valor 
						//para la constante del objeto
		this.dni = "00000000";
	}
	
	public Persona (String nombre, int edad , String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni; //Es el unico obligatorio, ver como clave primaria!
		
	}
	
	//Setters y Getters
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	///NO SE PUEDE GENERAR setDNI, no se puede modificar! como Clave Primaria
	public String getDni() {
		return dni;
	}

}
