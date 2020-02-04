package poliformismo;

import ClasesyObjetos.Private_public_get_set;
import herencia.FechaDetallada;

public class Testpoli {

	public static void main(String[] args) {
		Private_public_get_set fec = new FechaDetallada ("1/05/1986");
		Object obj =new FechaDetallada ("19/8/2016");
		System.out.println("Clase Padre toma valor de la hija = " + fec);
		System.out.println("Clase Padre principal Object toma valor de la nieta = " + obj);
		
		//Ambos imprimen igual porque contienen objetos de la misma clase
		
		Object [] arr = {new Private_public_get_set(2,10,1986),new FechaDetallada("2/10/1987"),
				new String("2,10,1556"),new Integer(2)};
				///Private_public_get_set= Fecha error inicial con los nombres
		for (int i = 0; i<arr.length; i++) {
			System.out.println("arr["+i+"] "+arr[i]);
		}
		///Object bebe de Fecha(Private_public_get_set) Fecha detallada 
		///y puede tener objetos de cualquier tipo por definincion de Object
	}
}
