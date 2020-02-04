package edu.ucam.aplicacion;

import java.io.Serializable;
import java.util.Date;

public class Trabajo implements Serializable {

	private static final long serialVersionUID = 1L;
	private float precio;
	private Date inicio;
	private Date fin;
	private Automovil auto;
	private Persona cliente;
	private Persona mecanico;
	
	public Trabajo(float precio, Date inicio, Date fin, Automovil auto, Persona cliente, Persona mecanico) {
		super();
		this.precio = precio;
		this.inicio = inicio;
		this.fin = fin;
		this.auto = auto;
		this.cliente = cliente;
		this.mecanico = mecanico;
	}
	public float getPrecio() {

		return precio;
	}
	public void setPrecio() {
		int anio = (fin.getYear() - fin.getYear()) * (12 - (inicio.getMonth() - fin.getMonth()));
		int mes = (fin.getMonth() - inicio.getMonth() )*30;
		int dias = (fin.getDay() - inicio.getDay()) + mes;
		if(dias < 0)
			dias*= -1;
		this.precio = dias * 9.5f;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Automovil getAuto() {
		return auto;
	}
	public void setAuto(Automovil auto) {
		this.auto = auto;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public Persona getMecanico() {
		return mecanico;
	}
	public void setMecanico(Persona mecanico) {
		this.mecanico = mecanico;
	}
	//Ejemplo Manejo de Extensiones
	@Override
	public String toString() {
		try {
		String lineaCliente = "\nTrabajo---Precio : " + precio + " Fecha Inicio : " + inicio + " Fecha de Fin: " + fin + 
				"\nAutomovil---Marca: " + auto.getMarca() + " Matricula : " + auto.getMatricula() +
				"\nCliente---Nombre: "+ cliente.getNombre() + " DNI: " + cliente.getDni();
		
		
		try {
		return lineaCliente+
				"\nMecanico---Nombre: " + mecanico.getNombre() +" " + mecanico.getApellido();
	
		}catch(NullPointerException e) {
			return lineaCliente +"\n Mecanico no Introducido \n";
		}
		}catch (Exception e) {
			return "Trabajo Incompleto";
		}
	}
}
