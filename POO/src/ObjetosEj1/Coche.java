package ObjetosEj1;

import java.util.Scanner;
public class Coche {
	
	private String marca;
	private String modelo;
	private float precio;
	
	public Coche (String marca, String modelo, float precio) {
		
		this.marca = marca;
		this.modelo =modelo;
		this.precio = precio;
	}
	
	public float getPrecio() {
		
		return precio;
		
	}
	
	public String mostrarDatos() {
	
		return "Marca : " + marca + " Modelo : " + " Precio : " + precio;
	}
	
	public static Coche indiceCocheBarato(Coche coches[]) {
		Coche aux = new Coche (null,null,0);
		aux.precio = coches[0].getPrecio();
		aux.marca = coches[0].marca;
		aux.modelo = coches[0].modelo;
		
		for ( Coche i : coches) {
			
			if( i.precio < aux.precio ) {
				aux.precio = i.precio;
				aux.marca = i.marca;
				aux.modelo = i.modelo;
			}
		}
		return aux;
	}

	public static void main(String[] args) {
		Coche aux;
		Scanner entrada = new Scanner(System.in);
		String marca, modelo;
		float precio;
		int cantidad;
		System.out.println("Cuantos vehiculos va a introducir ");
		cantidad = entrada.nextInt();
		Coche c[] = new Coche[cantidad];
		
		for (int i = 0; i < c.length ; i++) {
			entrada.nextLine();//vacia buffer
			System.out.println("Introduzca las caracteristicas del coche " +(i+1));
			System.out.println("Marca :");
			marca = entrada.nextLine();
			System.out.println("Modelo : ");
			modelo = entrada.nextLine();
			System.out.println("Introduzca precio: ");
			precio = entrada.nextFloat();
			
			c[i] = new Coche(marca,modelo,precio);
		}
		aux = indiceCocheBarato(c);
		System.out.println("El coche mas barato es : " + aux.marca + "--" + aux.modelo +"--" + aux.precio);
        
		
	}
}
