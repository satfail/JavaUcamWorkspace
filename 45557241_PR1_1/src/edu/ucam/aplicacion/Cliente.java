package edu.ucam.aplicacion;

import java.util.Date;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private Date fechaAlta;
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, String dni, Automovil auto) {
		super(nombre, apellido, dni, auto);
	}

	public Cliente(String nombre, String apellido, String dni, Automovil auto, String idCliente, Date fechaAlta) {
		super(nombre, apellido, dni, auto);
		this.idCliente = idCliente;
		this.fechaAlta = fechaAlta;
	}
	
	public Cliente (Cliente c) {
		this.fechaAlta = c.getFechaAlta();
		this.idCliente = c.getIdCliente();
		this.setNombre(c.getNombre());
		this.setApellido(c.getApellido());
		this.setDni(c.getDni());
		this.setAuto(c.getAuto());
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return super.toString() + getDetalle();
	}

	@Override
	public String getDetalle() {

		return "\t Cliente: "+ "Fecha Alta : " + getFechaAlta();
	}
	
	
	
	
	

}
