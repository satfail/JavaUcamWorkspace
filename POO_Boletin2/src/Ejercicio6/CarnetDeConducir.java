package Ejercicio6;
import java.util.Comparator;

public class CarnetDeConducir  implements CarnetPorPuntos, Comparable<CarnetDeConducir>{
	
	private String nombre;
	private int puntos, mesesSinInfracciones;
	
	public CarnetDeConducir() {
		this.puntos = 1;
		this.nombre = "prueba";
		this.mesesSinInfracciones = 0;
		
	}
	
	public  CarnetDeConducir(String nombre) {
		this.nombre = nombre;
		puntos = 12;
		mesesSinInfracciones = 25;
	}

	public int getPuntos() {
		return puntos;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int mesesSinInfracciones() {
			return mesesSinInfracciones;
	}
	

	public void darUnPunto() {
		this.puntos++;
	}

	@Override
	public void sumarPuntos(int bonificacion) {
		puntos += bonificacion;
		
	}
	public int compareTo(CarnetDeConducir carnet) {
		int resultado = 0;
		
		if(carnet.getPuntos() > puntos)
			resultado = -1;
		else if (carnet.getPuntos() == puntos) {
			resultado = 0;
		}
		else
			resultado = 1;

		return resultado;
	}

	

}
