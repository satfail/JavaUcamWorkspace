package personal;

import java.util.Collections;
import java.util.LinkedList;

import ejemploCriterios.CriterioSueldo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Persona> lista = new LinkedList<Persona>();
		
		LinkedList<Empleado> lista_empleados = new LinkedList<Empleado>();
		
		Empleado e1 = new Empleado();
		Empleado e2 = new Empleado();
		Empleado e3 = new Empleado();
		
		e1.setSueldo (400);
		e1.setSueldo (1200);
		e1.setSueldo (200);
		
		//e1.setEdad (40);
		//e1.setEdad (18);
		//e1.setEdad (20);
		
		
		Cliente c = new Cliente();
		lista.add(c);
		
		lista_empleados.add(e1);
		lista_empleados.add(e2);
		lista_empleados.add(e3);	
		
		Collections.sort(lista_empleados, new CriterioSueldo());
		//Collections.sort(lista_empleados, new CriterioEdad());
		
		for (Persona p: lista) {
			System.out.println(p.getInformacion());
		}
		
		for (Empleado e: lista_empleados) {
			System.out.println(e.getSueldo());
		}
	}

}
