package Ejercicio5;

public class Garaje {
	
	public int plazasGaraje;
	int i = 0;
	Vehiculo[] vehiculosGaraje;
	public Garaje(int plazasGaraje) {
		super();
		this.plazasGaraje = plazasGaraje;
	    vehiculosGaraje  = new Vehiculo [plazasGaraje];
	}
	
	 int calcularCuota(Vehiculo v) {
		if(v instanceof Moto) {
			return v.getPotencia() * 2;
		}
		else {
			return ((Coche)v).numPlazas * v.getPotencia();
		}
		
	}
	
	public void guardarVehiculo(Vehiculo v) {
		
			if(i < vehiculosGaraje.length) {
				vehiculosGaraje[i] = v;
				i++;
			}
			else {
				System.out.println("No hay mas espacio en el garaje");
			}
		
	}
	
	public void leerCuota(Vehiculo v) {
		
			for(int i = 0; i < vehiculosGaraje.length; i++) {
				
				if(vehiculosGaraje[i].equals(v)) {
					System.out.println(calcularCuota(vehiculosGaraje[i]));
				}
		}
		
		
	}

}
