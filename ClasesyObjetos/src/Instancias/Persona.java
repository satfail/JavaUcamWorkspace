package Instancias;

import ClasesyObjetos.Private_public_get_set;
import herencia.FechaDetallada;

public class Persona {
	
	private String nombre;								//atributos
	private String dni;									//
	private Private_public_get_set fechaNacimiento;		//
	///Seguimos con el error del nombre de la clase para la fecha
	
	private int cont = 0;		//Variable de estado
	
	
	public Persona(String nombre, String dni, Private_public_get_set fechaNacimiento) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	public String toString() {
		
		cont++;  /// Es independiente para cada instancia(objeto)
		return nombre + ", DNI : " + dni + " , nacido el : " + fechaNacimiento +" ( " + cont + " )";
	}
	//setters y getters
}
