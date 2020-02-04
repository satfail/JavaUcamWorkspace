package Comparable;

import Instituto.Alumno;

public class CriterioAlumNotaProm extends Criterio<Alumno> {

	public int comparar (Alumno a, Alumno b) {
		
		double diff = a.getNotaPromedio() - b.getNotaPromedio();
		return diff > 0 ? 1 : diff < 0 ? -1 : 0 ; // ¿mayor que 0? --> 1 ; ¿menor que ? --> -1 ; else 0 //ya devolvemos un valor entero 
		
	}
	
}
