package ArrayList_Vector;

import java.util.Vector;
import java.util.Collection;
import java.util.ArrayList;

public class Test {

	public static Collection<String> obtenerLista(){
		Vector<String> v = new Vector<String>();
		
		v.add("Lucas");
		v.add("Carmen");
		v.add("Maria Jose");
		
		return v;
		
	}
	
	
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>(); //podemos cambiar Vector por ArrayList ya que implementan las mismos adders y getters
												 // ademas tb implementa Collection por lo tanto podemos hacer colecciones de este tipo
		
		v.add("Pedro");
		v.add("Juan");
		v.add("Maria");
		String aux;
		
		for (int i = 0 ; i < v.size(); i++) {
			
			aux = v.get(i);
			System.out.println(aux);
		}
		
		
		Collection<String> c = obtenerLista(); //La clase collection implementa vector, por eso podemos meter los vector de obtenerLista
											   // en  Collection
		
		for (String nom : c)
			System.out.println(nom);
		
		
	}
	
}
