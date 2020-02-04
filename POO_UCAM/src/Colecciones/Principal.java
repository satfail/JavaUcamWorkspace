package Colecciones;

import java.util.LinkedList;

public class Principal {
	
	public static void main(String[] args) {
		
		LinkedList<Automovil> listaAutomovil = new LinkedList<Automovil>();
		
		Coche c1 = new Coche("Ferrari", 1002, "Rojo");
		Coche c2 = new Coche("Porche", 2002, "Blanco");
		Moto m1 = new Moto("Honda", 8000, "Verde");
		Moto m2 = new Moto("Ducati", 12000, "Negra");
		
		listaAutomovil.add(c1);
		listaAutomovil.add( c2);
		listaAutomovil.addFirst(m1);
		listaAutomovil.add(m2);
		listaAutomovil.add(3, c2);
		
		
		for(Automovil a : listaAutomovil) {
			if (a instanceof Coche) {
				
				System.out.println(((Coche)a).getMarca() + " " + a.Consumo());
			}
			else {
				System.out.println(((Moto)a).getMarca() + " " + a.Consumo());
			}
		}
	}
					

				
}
