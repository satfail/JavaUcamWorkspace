package ejercicio9;

public  abstract class  Producto {
	protected static String nombre;
	
	
	
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}



	public abstract String getNombre();
		
	
	
	public static void main(String[] args) {

		
	}
	
	

}
// Hay que definir la clase como abstracta y proporcionoar un metodo abstracto