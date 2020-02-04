package EquipoFutbol;

public class Entrenador extends Persona{
	
	private String estrategia;

	public Entrenador(String nombre, String apellidos, int edad, String estrategia) {
		super(nombre, apellidos, edad);
		this.estrategia = estrategia;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	
	@Override
	public void partidoFutbol() {
		System.out.println("El Entrenador dirige el partido con la estrategia "   + estrategia);
	}
	
	@Override
	public void entrenamiento() {
		
		System.out.println("El entrenador dirige un entrenamiento ");
	}
	
	public void planificarEntrenamiento() {
		
		System.out.println("El entrenamiento esta planificado ");
	}

}
