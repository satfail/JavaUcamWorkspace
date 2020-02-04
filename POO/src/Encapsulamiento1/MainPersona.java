package Encapsulamiento1;

public class MainPersona {
	
	public static void main(String[] args) {
		Persona p = new Persona();
		Persona p2 = new Persona ("Maria Jose", 34, "458787878f");
		p.setEdad(15);
		p.setNombre("Miguel");
		System.out.println("Hola "+p.getNombre() + " " + p.getEdad() + " " + p.getDni());
		System.out.println("Hola "+p2.getNombre() + " " + p2.getEdad() + " " + p2.getDni());
	}

}
