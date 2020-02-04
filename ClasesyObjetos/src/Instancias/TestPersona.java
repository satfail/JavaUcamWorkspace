package Instancias;

import herencia.FechaDetallada;

public class TestPersona {
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona("Juan", "466447741c", new FechaDetallada(23,3,1971));
		Persona p2 = new Persona("Pedro", "12236646c", new FechaDetallada(12,6,1968));
		
		System.out.println(p1);
		System.out.println(p1);
		System.out.println(p1);
		System.out.println("----------------------");
		System.out.println(p2);
		System.out.println(p2);
		System.out.println("----------------------");
		System.out.println(p1);
		System.out.println(p1);
	}

}
