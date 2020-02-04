package Ejercicio5;

public class Principal {
	
	public static void main(String[] args) {
		Garaje garaje1 = new Garaje(2);
		Moto m1 = new Moto(200);
		Coche c1 = new Coche(200, 4);
		garaje1.guardarVehiculo(m1);
		garaje1.guardarVehiculo(c1);
		garaje1.leerCuota(m1);
	}

}
