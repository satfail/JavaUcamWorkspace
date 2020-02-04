package edu.ucam.estructuraclases;

import java.io.Serializable;

public class Expediente implements Serializable {

	private static final long serialVersionUID = 1L;
	private String observaciones,tratamiento;
	private Paciente p;
	public Expediente(String observaciones, String tratamiento, Paciente p) {
		super();
		this.observaciones = observaciones;
		this.tratamiento = tratamiento;
		this.p = p;
	}
	public Expediente() {
		super();
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Paciente getP() {
		return p;
	}
	public void setP(Paciente p) {
		this.p = p;
	}
	
	
	

}
