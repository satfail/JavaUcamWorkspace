package edu.ucam.aplicacion;

public class Turismo extends Automovil {

	private static final long serialVersionUID = 1L;
	private int nPuertas;
	private float capacidad;
	public Turismo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turismo(String matricula, int caballos, String marca, String modelo, String tipoAveria, String estadoReparacion) {
		super(matricula, caballos, marca, modelo, tipoAveria, estadoReparacion);

	}
	public Turismo(String matricula, int caballos, String marca, String modelo) {
		super(matricula, caballos, marca, modelo);

	}
	public Turismo(String matricula, int caballos, String marca, String modelo, int nPuertas, float capacidad) {
		super(matricula, caballos, marca, modelo);
		this.nPuertas = nPuertas;
		this.capacidad = capacidad;
	}
	
	public Turismo(Turismo t) {
		this.setnPuertas(nPuertas);
		this.setCapacidad(capacidad);
		this.setCaballos(t.getCaballos());
		this.setMarca(t.getMarca());
		this.setModelo(t.getModelo());
		this.setMatricula(t.getMatricula());
		this.setTipoAveria(t.getTipoAveria());
		this.setEstadoReparacion(t.getEstadoReparacion());
	}
	public int getnPuertas() {
		return nPuertas;
	}
	public void setnPuertas(int nPuertas) {
		this.nPuertas = nPuertas;
	}
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return super.toString() + getDetalle();
	}

	@Override
	public String getDetalle() {

		return  "\t Automovil Puertas: " + getnPuertas() + " Capacidad : " + getCapacidad();
	}
	
	

}
