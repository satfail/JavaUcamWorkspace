package Polimorfismo;

//Un objeto de la superclase puede almacenar un objeto de cualquiera de las
//subclases, Un Vehiculo puede ser un Coche, Moto , Avion...
//Esta realacion no es bidireccional, los hijos no pueden englobar
//Puedo instanciar el objeto vehiculo con cualquiera de las subclases
// Vehiculo miVehiculo = new Avion();



public class Vehiculo {
	
	protected String matricula;
	protected String marca;
	protected String modelo;
	public Vehiculo(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
	public String mostrarDatos() {
		
		return "Matricula: " + matricula + " Marca: " + marca + " Modelo: " + modelo;
	}

}
