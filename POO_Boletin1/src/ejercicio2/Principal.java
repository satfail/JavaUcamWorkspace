package ejercicio2;

public class Principal {
	
	public static void main(String[] args) {
		
		Persona persona1 = new Persona("Lucas", 1994, "24242424X", 1.70f);
		System.out.println("Si estamos a 2013 la edad de " + persona1.getNombre() + " es de " 
												+ persona1.calculaEdad(2013)  + " primaveras." );
	}
	

}
