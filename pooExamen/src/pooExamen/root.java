package pooExamen;

public class root {

	public static void main(String[] args) {
		
		Casa miCasa = Casa.getInstanciaCasa();
		miCasa.getSensor().add(new SensorMovimiento(12));
		((SensorMovimiento)miCasa.getSensor().get(0)).setMovimiento(true);
		miCasa.getSensor().add(new SensorPresion(11, 13.5f));
		miCasa.getSensor().add(new SensorTemperatura(13, 13.5f));
		
		miCasa.listarSensores();
		miCasa.buscarSensor(12);
	}

}
