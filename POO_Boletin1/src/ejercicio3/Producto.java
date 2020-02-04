package ejercicio3;

public class Producto {
	private String nombre;
	private float precio = 0;
	
	public  Producto(){
		System.out.println("Producto creado");
	}

	public Producto(String nombre, float d) {
		this.nombre = nombre;
		this.precio = d;
	}
	
	public String getInformacion() {
		return "Nombre : " + nombre + ", Precio : " + precio;
		
	}
	
	public static void main(String[] args) {
		Producto p1 = new Producto();
		Producto p2 = new Producto("Coca Cola", 2.97f);
		System.out.println(p2.getInformacion());
		
	}
	
	

}
