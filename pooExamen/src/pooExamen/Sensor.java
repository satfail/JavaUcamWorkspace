package pooExamen;

public abstract class Sensor {
	
	private int id = 0;
	public Sensor(int id) {
		this.id = id;
	}
	
	public Sensor() {}
	public Sensor(Sensor copia) {
		this.id = copia.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return " ID : " + id;
	}
	
	public abstract int obtenerValor();
	public abstract String getDetalle();
	
	

}
