package ObjetosEj1;
import java.util.Scanner;
public class Atleta {

	private int numero;
	private String nombre;
	private float tiempo;
	
	public Atleta() {
		
	}
	
	public Atleta (int numero, String nombre, float tiempo){
		
		this.nombre = nombre;
		this.numero = numero;
		this.tiempo = tiempo;
	}
	
	
	public float getTiempo() {
		return tiempo;
	}
	
	public String motrarCorredor () {
		
		return "Numero de Atleta : " + numero + "\n Nombre : " + nombre + "\n Tiempo"+ tiempo;
		
	}
	
	
	public static  Atleta mejorAtleta (Atleta corredores[]) {
		Atleta aux = new Atleta();
		aux.nombre = corredores[0].nombre;
		aux.numero = corredores[0].numero;
		aux.tiempo = corredores[0].getTiempo();
		
		for (int i = 0; i < corredores.length; i++) {
			
			if ( corredores[i].tiempo < aux.tiempo) {
				
				aux.nombre = corredores[i].nombre;
				aux.numero = corredores[i].numero;
				aux.tiempo = corredores[i].getTiempo();
			}
		}
		
		return aux;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numero;
		String nombre;
		float tiempo;
		int cantidad;
		
		System.out.println("Introduzca en nº de Atletas que participan : ");
		cantidad = entrada.nextInt();
		Atleta corredores[] = new Atleta[cantidad];
		
		for (int i = 0; i < corredores.length; i++) {
			entrada.nextLine();
			System.out.println("Introduzca los datos del Atleta Nº " + (i+1));
			System.out.print("Nombre : ");
			nombre = entrada.nextLine();
			System.out.print("Numero : ");
			numero = entrada.nextInt();
			System.out.print("Tiempo de Carrera : ");
			tiempo = entrada.nextFloat();
			corredores[i] = new Atleta(numero , nombre , tiempo);
		}
		//Esto computacionalmente es una mierda,pero es par a ver que
		//Los metodos que devuelven clases, tb devuelve sus metodos internos!
		System.out.println("El Ganador de la carrera es " +  mejorAtleta(corredores).numero +"--" + mejorAtleta(corredores).nombre +"--"+ mejorAtleta(corredores).tiempo);
		
	}
	
	
	
	
}
