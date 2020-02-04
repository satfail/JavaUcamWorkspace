package Herencia;
//Forma de reutilizacion de software, en la que se crea una clase nueva que
//aborbe los mienbros de una clase existente
//estudiante hereda de persona
public class Estudiante extends Persona{
	
	private int numEstudiante;
	double notaFinal;
	
	public Estudiante(String nombre, String apellido, int edad , int numEstudiante, double notaFinal) {
	//Hay que poner los atributos de donde hereda
	
		//Ya esta inicializados , se indica asi
		super(nombre,apellido,edad);
	//Ahora los atributos que son propios
		this.numEstudiante = numEstudiante;
		this.notaFinal = notaFinal;
		
	}
	
	public void mostarDatos() {
		//Los modificadores de acceso private no deja acceder a la variable 
		//directamente, tiene que ser por un getter o modificar a protected
		//protected puede accederse desde los hijos
		System.out.println("Nombre : " + nombre);//Accedo a protected
		System.out.println("Apellido : " + getApellidos());//Accedo a privado
		System.out.println("Codigo estudiante: " + numEstudiante);
		System.out.println("Nota Final : " + notaFinal);
	}

}
