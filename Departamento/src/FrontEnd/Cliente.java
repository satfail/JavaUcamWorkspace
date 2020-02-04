package FrontEnd;

import java.util.Collection;
import java.util.Scanner;

import BackEnd.DeptDTO;
import BackEnd.EmpDTO;
import Facade.Facade;

public class Cliente {
	
	public static void main(String[] args) {
		
		Facade facade = new Facade();
		Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();
		_mostrarDepartamentos(collDepts);
		
		Scanner scanner = new Scanner(System.in);
		int depno = scanner.nextInt();
		
		Collection<EmpDTO> collEmps = facade.obtenerEmpleados(depno);
		_mostrarEmpleados(collEmps , depno);
		
	}

	private static void _mostrarDepartamentos(Collection<DeptDTO> collDepts) {
		System.out.println("Departamentos: ");
		System.out.println("---------------->");
		
		for(DeptDTO dto : collDepts) {
			System.out.println("| " + dto.getDepno() + "\t");
			System.out.println("| " + dto.getDname() + "\t");
			System.out.println("| " + dto.getLoc() + "\t|");	
		}
		System.out.println("<----------------");
		System.out.print("Ingrese depno : ");
	}
	
	private static void _mostrarEmpleados(Collection<EmpDTO> collEmps, int depno ) {
		
		System.out.println("Empleados del departamento:  " + depno );
		System.out.println("------------------------->");
		
		for(EmpDTO dto : collEmps) {
			System.out.println("| " + dto.getEmpno() + "\t");
			System.out.println("| " + dto.getEname() + "\t");
			System.out.println("| " + dto.getDate() + "\t|");	
		}
		System.out.println("<-------------------------");

	}
		
	
}
