package Ejercicio7;

import java.io.Serializable;

public class Coche implements Serializable {
	
	private String modelo;
	private String marca;
	private String color;
	private int km;
	public Coche(String modelo, String marca, String color, int km) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.km = km;
	}
	
	public Coche(Coche c) {
		this.color = c.getColor();
		this.modelo = c.modelo;
		this.marca = c.marca;
		this.km = c.km;
	}
	public void printdata(Coche c) {
		
		System.out.println("modelo = " +  c.getModelo());
		System.out.println("marca = " + c.getMarca());
		System.out.println("color  = " + c.getColor());
		System.out.println("km = "+ c.getClass());
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
