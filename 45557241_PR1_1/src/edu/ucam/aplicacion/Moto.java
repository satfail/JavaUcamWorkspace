package edu.ucam.aplicacion;

public class Moto extends Automovil {

	private static final long serialVersionUID = 1L;
	private int cilindrada;
	private String tipoMoto;

	public Moto() {}
	
	public Moto(String matricula, int caballos, String marca, String modelo, String tipoAveria, String estadoReparacion) {
		super(matricula, caballos, marca, modelo, tipoAveria, estadoReparacion);

	}
	public Moto(String matricula, int caballos, String marca, String modelo) {
		super(matricula, caballos, marca, modelo);

	}
	public Moto(String matricula, int caballos, String marca, String modelo, int cilindrada, String tipoMoto) {
		super(matricula, caballos, marca, modelo);
		this.cilindrada = cilindrada;
		this.tipoMoto = tipoMoto;
	}
	public Moto(Moto m) {
		this.setCilindrada(cilindrada);
		this.setTipoMoto(tipoMoto);
		this.setCaballos(m.getCaballos());
		this.setMarca(m.getMarca());
		this.setModelo(m.getModelo());
		this.setMatricula(m.getMatricula());
		this.setTipoAveria(m.getTipoAveria());
		this.setEstadoReparacion(m.getEstadoReparacion());
		
	}
	
	
	
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getTipoMoto() {
		return tipoMoto;
	}
	public void setTipoMoto(String tipoMoto) {
		this.tipoMoto = tipoMoto;
	}
	@Override
	public String toString() {
		return super.toString() + getDetalle();
	}

	@Override
	public String getDetalle() {
		return "\t Moto Tipo: " + getTipoMoto() + "Cilindrada : " + getCilindrada();
	}
	
	
	
}
