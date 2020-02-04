package pooExamen;

public class SensorMovimiento extends Sensor {
	
	private boolean movimiento;
	
	public SensorMovimiento(int id) {
		super(id);
		movimiento = false;
	}

	public boolean isMovimiento() {
		return movimiento;
	}

	public void setMovimiento(boolean movimiento) {
		this.movimiento = movimiento;
	}
	@Override
	public int obtenerValor() {
		int resultado = 0;
		
		if(movimiento == true)
			resultado = 1;
		
		return resultado;
	}
	@Override
	public String getDetalle() {
		return  " Movimiento " + obtenerValor();
	}
	
	@Override
	public String toString(){
		return "Sensor Movimiento " + super.toString() + getDetalle();
	}

}
