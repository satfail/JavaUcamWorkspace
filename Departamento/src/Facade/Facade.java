package Facade;

import java.util.Collection;

import BackEnd.DeptDAO;
import BackEnd.DeptDTO;
import BackEnd.EmpDAO;
import BackEnd.EmpDTO;

public class Facade {

	public Collection<DeptDTO> obtenerDepartamentos(){ //Obtiene la coleccion de todos los depertamantos
		
		DeptDAO deptDao = new DeptDAO(); //Creamos la clase y devolvemos la clase del BACKEND
		return deptDao.buscarTodos();
		
	}
	
	public Collection<EmpDTO> obtenerEmpleados(int depno){ // Obtiene los empleados de un departamento en concreto
		
		EmpDAO empDAO = new EmpDAO();
		return empDAO.buscarXDept(depno);
	}
}
