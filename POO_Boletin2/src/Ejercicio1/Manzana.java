package Ejercicio1;

public class Manzana {
	
	private String tipo;
	private float peso;
	private float precioKg;
	public Manzana(String tipo, float peso, float precioKg) {
		super();
		this.tipo = tipo;
		this.peso = peso;
		this.precioKg = precioKg;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getPrecioKg() {
		return precioKg;
	}
	public void setPrecioKg(float precioKg) {
		this.precioKg = precioKg;
	}
	
	public float getPrecioTotal() {
		
		return peso * precioKg;
	}
	
	public String toString() {
		
		return tipo + " " + peso + "kg  = ";
	}
	
	public static void main(String[] args) {
		Manzana m1 = new Manzana("roja", 4.6f, 1.2f);
		System.out.println(m1.toString()+ m1.getPrecioTotal() + "$");
		
		
		
	}

}
