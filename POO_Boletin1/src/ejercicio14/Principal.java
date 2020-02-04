package ejercicio14;

import java.util.ArrayList;

public class Principal {
	
public static void main(String[] args) {
	ArrayList<Caja> caja1 = new ArrayList<Caja>();
			
	for(int i = 0 ; i < 10 ; i++) {
		caja1.add(new Caja(i));
	}
	
	for(Caja c : caja1) {
		System.out.println(c.getHueco());
	}

}
}
