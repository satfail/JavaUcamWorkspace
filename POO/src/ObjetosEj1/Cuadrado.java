package ObjetosEj1;

public class Cuadrado {

	private float lado1;
	private float lado2;
	
	public Cuadrado (float l1, float l2) {
	
		this.lado1 = l1;
		this.lado2 = l2;
	}
	
	public Cuadrado(float l1) {
		
		this.lado1 = this.lado2 = l1;
	}
	
	public float getPerimetro(){
		
		float perimetro = 2*(lado1 + lado2) ;
		return perimetro;
	}
	
	public float getArea() {
		return lado1*lado2;
	}
	
	public static void main(String[] args) {
		Cuadrado c = new Cuadrado(5.1f , 8.3f);
		Cuadrado c2 = new Cuadrado (4.09f);
		
		System.out.println("C1 area " + c.getArea());
		System.out.println("C2 perimetro " + c2.getPerimetro());
	}
}
