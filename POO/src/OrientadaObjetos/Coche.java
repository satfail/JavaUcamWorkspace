package OrientadaObjetos;

public class Coche {
	
	//Atributos de la Clase
	String color;
	String marca;
	int km;

	//Metodo main
	public static void main(String[] args) {
		
		Coche car1 = new Coche();
		Coche car2 = new Coche();
		
		car1.color = "Rojo";
		car1.marca = "Ferrari";
		car1.km = 1000;  //Variables no declaradas como publicas o privadas
						 // Si quiero acceder desde fuera public
						 // Si no hay que crear getters y setters
		
		car2.color = "Verde";
		car2.marca = "Audi";
		car2.km = 0;
		
		System.out.println("Coche 1 : " + car1.marca +  " " + car1.color +  " " + car1.km);
		System.out.println("Coche 2 : " + car2.marca +  " " + car2.color +  " " + car2.km);
	}
	
}
