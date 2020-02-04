package Instituto;

public class TestOrdenar {

	public static void main(String[] args) {
		
		Alumno arr[] = {
				new Alumno("Lucas", 20 , 9.7),
				new Alumno ("Carmen", 17, 8.5),
				new Alumno("Maria Jose", 15 , 8.01),};
		Util.ordenar(arr);
		muestraArray(arr);
		
		String arr2[]= {"Miguel", "Ana", "Borja" };
		Integer arr3[] = { new Integer(6),new Integer(7),new Integer(1),new Integer(2),new Integer(56),new Integer(23),new Integer(12),
				new Integer(5),new Integer(8)};
		// La clase Comparable pude comparar Integers y Strings ,además la hemos implemtentado como interface en la classe alumno
		// sobreescribiendo en comparaTo para que pueda comparar alumnos
		
		Util.ordenar(arr2);
		Util.ordenar(arr3);
		muestraArray(arr2);
		muestraArray(arr3);
		
		
	}
	@SuppressWarnings ("unchecked")
	private static void muestraArray(Comparable arr[]) {
		
		for( int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}	
}
