package Genericas;

public class Principal {
	

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Lucas");
		Pareja<Persona> pareja1 = new Pareja<Persona>();
		pareja1.setPrimero(p1);
		System.out.println(pareja1.getPrimero()); // Devuelve el nombre
		System.out.println(pareja1.toString());//Devuelve el objeto , no hay to String definido
		
		
		Pareja<Integer> int1 = new Pareja<Integer>();
		int1.setPrimero(10);
		System.out.println(int1.getPrimero()); //Aqui no devuelve la clase, ya mete el valor
		
		

	}
	

}
