package pooExamen;

public class SensorPresion extends Sensor{
	
	
	private float presion;
	
	public SensorPresion(int id ,float presion) {
		super(id);
		this.presion = presion;
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

	@Override
	public String toString() {
		return "SensorPresion " + super.toString() + getDetalle();
	}

	@Override
	public int obtenerValor() {
		int resultado = (int) presion *3;
		return resultado;
	}

	@Override
	public String getDetalle() {
		return  " Presion : " +obtenerValor();
	}
	
	

}
