package OrientadaObjetos;

public class Persona {

	String nombre;
	int edad;
	String dni;
	
	public Persona(String nom ,int edad) { //Constructor de Persona	
		this.nombre = nom;
		this.edad = edad;	///This es la variable de los atributos
	}
	
	public Persona(String dni) { //Sobrecarga, se puede siempre que sean distintos los parametros
								 // o sean diferentes
		this.dni = dni ;
	}
	
	public void mostrarDatos() {
		
		System.out.println("El nombre es " + nombre);
		System.out.println("La edad es " + edad);
	}

	public static void main(String[] args) {
		Persona p = new Persona("Lucas", 3);
		Persona p2 = new Persona("85544665z");
		p.mostrarDatos();
		p2.mostrarDatos();
	}
}

//Java diferencia por el tipo de datos y la cantidad para la sobrecarga de metodos!!