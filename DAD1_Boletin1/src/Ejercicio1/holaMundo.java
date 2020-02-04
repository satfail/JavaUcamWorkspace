package Ejercicio1;

public class holaMundo {
	
	private static final String  saludo = "Hola Mundo";
	
	public holaMundo () {}

	public static String getSaludo() {
		return saludo;
	}
	
	public static void main(String[] args) {
		holaMundo hola = new holaMundo();
		System.out.println(hola.getSaludo());
	}	

}
