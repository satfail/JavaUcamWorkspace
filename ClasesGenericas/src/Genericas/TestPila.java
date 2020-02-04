package Genericas;

public class TestPila {
	
	public static void main(String[] args) {
		
		MiPila<Integer> c = new MiPila<Integer>();
		
		c.apilar(1);
		c.apilar(2);
		c.apilar(3);
		
		System.out.println(c.desapilar());
		System.out.println(c.desapilar());
		
		c.apilar(4);
		
		System.out.println(c.desapilar());
		System.out.println(c.desapilar());
		
	}

}
