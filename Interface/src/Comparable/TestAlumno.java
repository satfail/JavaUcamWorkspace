package Comparable;
import Instituto.*;

public class TestAlumno {

	public static void main(String[] args) {
		
		Alumno arr[] = {
				new Alumno("Lucas", 20 , 9.7),
				new Alumno ("Carmen", 17, 8.5),
				new Alumno("Maria Jose", 15 ,9.01)};
		
		Util.ordenar2( arr , new CriterioAlumNombre());
		Util.imprimir(arr);
		
		Util.ordenar2(arr, new CriterioAlumNotaProm());
		Util.imprimir(arr);
		
	}
	
}
