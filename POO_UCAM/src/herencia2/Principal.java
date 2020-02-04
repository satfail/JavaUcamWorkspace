package herencia2;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Jefatura jefe_RRHH= new Jefatura("mada");
	
	System.out.println(jefe_RRHH.dameSueldo());
	
	jefe_RRHH.estableceIncentivo(35);
	
	System.out.println(jefe_RRHH.dameSueldo());
	

	
	//Polimorfismo
	
	Empleado misEmpleados[] =new  Empleado[3];
	

	misEmpleados[0] =new  Jefatura();
	misEmpleados[1] =new  Empleado("ana",5000,1,2,2018);
	misEmpleados[2] =new  Jefatura("juan");
	
	
	
	for (Empleado empleado : misEmpleados) {
		System.out.println("hola");
		System.out.println(empleado.toString());
	}

//System.out.println("Ejemplo polimorfismo: "+misEmpleados[0].toString() +"\n"+ misEmpleados[1].toString()+"\n"+ misEmpleados[2].toString());

	
//////Casting de Objetos LIGADURA DINÁMICA
	
	Jefatura jefa_seccion = (Jefatura) misEmpleados[0];
	jefa_seccion.estableceIncentivo(22);
	System.out.println(jefa_seccion.toString());

	

	
	
	


	 
	}

}
