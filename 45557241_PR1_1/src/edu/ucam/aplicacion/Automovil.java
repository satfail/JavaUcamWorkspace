package edu.ucam.aplicacion;

import java.io.Serializable;

public abstract class Automovil implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private int caballos;
	private String marca;
	private String modelo;
	private String tipoAveria;
	private String estadoReparacion;
	private String matricula;
	
	//Constructores
	public Automovil(String matricula, int caballos, String marca, String modelo) {
		this.matricula = matricula;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Automovil() {}
	public Automovil(String matricula, int caballos, String marca, String modelo, String tipoAveria,
			String estadoReparacion) {
		super();
		this.matricula = matricula;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoAveria = tipoAveria;
		this.estadoReparacion = estadoReparacion;
	}
	//Constructor Copia
	public Automovil(Automovil a) {
		this.matricula = a.getMatricula();
		this.caballos = a.getCaballos();
		this.marca = a.getMarca();
		this.modelo = a.getModelo();
		this.tipoAveria = a.getTipoAveria();
		this.estadoReparacion = a.getEstadoReparacion();
	}


	//ToString
	@Override
	public String toString() {
		return "Matricula :" + matricula + ", Caballos :" + caballos + ", Marca : " + marca + ", Modelo :" + modelo
				+ "\n";
	}

	//Getters  y Setters



	public int getCaballos() {
		return caballos;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getTipoAveria() {
		return tipoAveria;
	}


	public void setTipoAveria(String tipoAveria) {
		this.tipoAveria = tipoAveria;
	}


	public String getEstadoReparacion() {
		return estadoReparacion;
	}


	public void setEstadoReparacion(String estadoReparacion) {
		this.estadoReparacion = estadoReparacion;
	}
	
	public abstract String getDetalle();
	
	

}
