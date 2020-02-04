package Colecciones;

public class Coche  extends Automovil{

	private String marca;
	private float km;
	private String color;
	public Coche(String marca, float km, String color) {
		nRuedas = 4;
		this.marca = marca;
		this.km = km;
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public float getKm() {
		return km;
	}
	public String getColor() {
		return color;
	}
	
	public float Consumo() {
		return  (km*5.7f);
	}
	
	
	
	

	
	
	
}
