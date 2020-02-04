package ConstructorCopia;

public class Coche {
	
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private String color;
	
	
	public Coche() {
		
		ruedas=4;
		largo=2000;
		motor=1100;
		color="rojo";
	}


	//Constructor copia
	public Coche(Coche c) {
		
		this.ruedas = c.ruedas;
		this.ancho = c.ancho;
		this.largo = c.largo;
		this.motor = c.motor;
		this.color = c.color;
	}



	public int getRuedas() {
		return ruedas;
	}






	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}






	public int getMotor() {
		return motor;
	}




	public void setMotor(int motor) {
		this.motor = motor;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	public String dimeDatos() {
		
		return "Los datos del coche son: "+ "numero de ruedas: "+ruedas+"color del coche: "+ color;
	}
	
	
	
	

}
