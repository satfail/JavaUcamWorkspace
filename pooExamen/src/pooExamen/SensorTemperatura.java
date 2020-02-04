package pooExamen;

public class SensorTemperatura extends Sensor{

	private float temperatura;
	
	public SensorTemperatura(int id, float temperatura) {
		super(id);
		this.temperatura = temperatura;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public int obtenerValor() {
		int resultado = (int) temperatura;
		return resultado;
	}

	@Override
	public String getDetalle() {

		return "Temperatura : " + obtenerValor();
	}
	
	public String toString() {
		return "Sensor Temperatura " + super.toString() + getDetalle();
	}

}
