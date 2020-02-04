package Encapsulamiento1;
// A los atributos estaticos, se les conoce tb como miembros de clase
public class Estatico {
	
	private String frase = "Esta frase pertenece al objeto";
	//No es estatico, el atributo pertenece al objeto
	private static String frase2 = " ";
	
	public static int sumar (int x, int y) { //Se puede llamar sin instanciar
		x += y;
		return x;	
	}
	
	public static void main(String[] args) {
		Estatico ob1 = new Estatico();
		Estatico ob2 = new Estatico();
		
		ob2.frase = "El cambio, cambia al objeto, no es estatico";
		System.out.println(ob1.frase);
		System.out.println(ob2.frase);
		
		
		ob2.frase2 = "El cambio cambia a la clase, por que es estatico";
		System.out.println(ob1.frase2);
		System.out.println(ob2.frase2);
		
		//Una caracteristica de los objetos estaticos es que no necesitan que se
		//instancien para poder utilizarlos
		
		Estatico.frase2 = "Es mia ";
		System.out.println(Estatico.frase2);
		
		System.out.println(Estatico.sumar(5, 2));
		
	}
	
	//Utilizo static en atributos, cuando quiero que
	//algo cambie para todos mis objetos
	// Los metodoes estaticos Se cargan en memoria en tiempo de compilación 
	//y no a medida que se ejecutan las líneas de código del programa. 
	//Para invocar a un método estático no se necesita crear un objeto de la clase en la que se define.

	//Si se invoca desde la clase en la que se encuentra definido, basta con escribir su nombre.
	//Si se le invoca desde una clase distinta, debe anteponerse a su nombre, 
	//el de la clase en la que se encuentra seguido del operador punto (.) .metodoEstatico
	//Suelen emplearse para realizar operaciones comunes a todos los objetos de la clase. 
	//No afectan a los estados de los mismos (a los valores de sus variables de instancia).

	//Ejemplo, si se necesita un método para contabilizar el número de objetos creados de una clase, 
	//tiene sentido que sea estático ya que su función (aumentar el valor de una variable entera) 
	//se realizaría independientemente del objeto empleado para invocarle. Ejemplo contadorUniversal

	//No conviene usar muchos métodos estáticos, pues si bien se aumenta la rapidez de ejecución, 
	//se pierde flexibilidad, no se hace un uso efectivo de la memoria 
	//y no se trabaja según los principios de la Programación Orientada a Objetos

}
