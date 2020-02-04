package Instancias;

public class Numero {

	private double valor;
	
	public Numero(double v) {
		
		valor = v;
	}
	
	public Numero sumar (double a) {
		
		valor += a; //metodo de instancia ya que modifica el valor de la variable de instacia valor (no es estatica)
		return this; //retorna con la variable que se esta trabajando
	} ///Sobrecarga en el metodo sumar, puedo tener dos parametros o 1 , hacen cosas diferentes dependiendo de esto
	
	public static double sumar ( double a , double b) {
		
		return a + b;
	} //metodo suma
	
	public String toString() {
		
		return Double.toString(valor);
	}
	
}
