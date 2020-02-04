package Polimorfismo;
// UpCasting es convertir una subclase en una clase de la cual hereda
public class Avion extends Vehiculo {
	
	private int nRuedas;
	private String circula;

	public Avion(String matricula, String marca, String modelo, int nRuedas, String circula) {
		super(matricula, marca, modelo);
		this.nRuedas = nRuedas;
		this.circula = circula;
	}
	public int getnRuedas() {
		return nRuedas;
	}
	public void setnRuedas(int nRuedas) {
		this.nRuedas = nRuedas;
	}
	public String getCircula() {
		return circula;
	}
	public void setCircula(String circula) {
		this.circula = circula;
	}

	public String mostrarDatos() {
		return "Matricula: " + matricula + " Marca: " + marca + " Modelo: " + modelo+ "\nRuedas :"+nRuedas+" Circula : "+circula;
		
	}
}
