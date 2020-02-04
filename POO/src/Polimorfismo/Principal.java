package Polimorfismo;

public class Principal {

	
	public static void main(String[] args) {
		
		Vehiculo v1 = new Avion("1BaZ", "Boeing","747",3,"Aire");
		Vehiculo v2 = new Coche("4512AB","Audi","A8",4,"Carretera");
		System.out.println(v1.mostrarDatos());
		System.out.println(v2.mostrarDatos());
		
		Avion av1 = new Avion("1BaZ", "EspanAir","B12",6,"Aire");
		// Referencia = Instanciacion
		//Ahora con el Upscasting puedo pasar el Avion a Vehiculo
		Vehiculo v3 = av1;
		System.out.println(v3); //Lo guarda como avion
		
		//Ahora para el DownCasting , convertir a Avion otra vez
		
		Avion av2 = (Avion) v3;
		System.out.println(v3);
		
	}
}
