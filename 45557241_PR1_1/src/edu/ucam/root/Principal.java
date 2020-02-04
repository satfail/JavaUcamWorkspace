package edu.ucam.root;
//Metodo plantilla para los coches y a por la interfaz!

import java.io.IOException;
import java.util.Scanner;
import edu.ucam.crud.TallerSingleton;


public class Principal {

	 static TallerSingleton miTaller = TallerSingleton.getTallerSingleton();
	 
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		miTaller.leerDatosAuto();
		miTaller.leerDatos();
		miTaller.leerTrabajos();
		menu();
	}
	 
	
	public static void menu() {
		Scanner entrada = new Scanner(System.in);
		int flag = 0;
		
		do {
			System.out.println("Bienvenido al Taller");
			System.out.println("1. Gestion Cliente");
			System.out.println("2. Gestion Trabajos");
			System.out.println("3. Generar informes");
			System.out.println("4. Guardar");
			System.out.println("5. Salir");
			flag = entrada.nextInt();
			
			switch (flag) {
			case 1:
				gestionCliente();
				break;
				
			case 2:
				gestionTrabajos();
				break;
				
			case 3:
				generarInformes();
				break;
				
			case 4:
				miTaller.guardarDatos();
				miTaller.guardarTrabajos();
				break;

			default:
				break;
			}
			
		}while(flag !=5);
		
		
	}
		
	public static void gestionCliente() { //Static para que se pueda utilizar en toda la clase
		Scanner entrada = new Scanner(System.in);
		int flag = 0;
		
		do {
			System.out.println("1. Introducir Cliente");
			System.out.println("2. Buscar Cliente");
			System.out.println("3. Modificar Cliente");
			System.out.println("4. Eliminar Cliente");
			System.out.println("5. Modicar Automovil de Cliente");
			System.out.println("6. Salir");
			System.out.print("> ");
			flag = entrada.nextInt();
			switch (flag) {
			case 1:
				miTaller.addCliente();
				break;
			case 2:
				miTaller.buscarPersona();
				break;
			case 3:
				miTaller.updateCliente();
				break;
			case 4: 
				miTaller.eliminarCliente();
				break;
			case 5:
				miTaller.updateVehiculo();
				break;
			case 6:
				break;

			default:
				System.out.println("Comando incorrecto");
				break;
			}
		}while(flag != 6);
		
	}
	
	public static void gestionTrabajos() { //Static para que se pueda utilizar en toda la clase
		Scanner entrada = new Scanner(System.in);
		int flag = 0;
		
		do {
			System.out.println("1. Introducir Trabajo");
			System.out.println("2. Buscar Trabajo");
			System.out.println("3. Modificar Trabajo");
			System.out.println("4. Eliminar Trabajo");
			System.out.println("5. Finalizar Trabajo");
			System.out.println("6. Salir");
			System.out.print("> ");
			flag = entrada.nextInt();
			switch (flag) {
			case 1:
				miTaller.addTrabajo(miTaller.getPersonas());
				break;
			case 2:
				miTaller.buscarTrabajo().toString();
				break;
			case 3:
				miTaller.updateTrabajo();
				break;
			case 4: 
				miTaller.eliminarTrabajo();
				break;
			case 5:
				miTaller.finalizarTrabajo();
				break;
			case 6:
				break;
			default:
				System.out.println("Comando incorrecto");
				break;
			}
		}while(flag != 6);
		
	}
	
	
	public static void generarInformes() { //Static para que se pueda utilizar en toda la clase
		Scanner entrada = new Scanner(System.in);
		int flag = 0;
		
		do {
			System.out.println("1. Informe Personal");
			System.out.println("2. Informe Trabajo");
			System.out.println("3. Informe de Clientela");
			System.out.println("4. Informe de un Cliente");
			System.out.println("5. Informe de Vehiculos");
			System.out.println("6. Visitas de un modelo de vehiculo");
			System.out.println("7. Salir");
			System.out.print("> ");
			flag = entrada.nextInt();
			switch (flag) {
			case 1:
				miTaller.generarInformePersonal();
				break;
			case 2:
				miTaller.generarInformeTrabajos();
				break;
			case 3:
				miTaller.generarInformeClientes();
				break;
			
			case 4:
				miTaller.expedienteCliente();
				break;
			case 5: 
				miTaller.informeVehiculos();
				break;
			case 6: 
				miTaller.visitasModeloThisYear();
				break;
			case 7:
				break;
			default:
				System.out.println("Comando incorrecto");
				break;
			}
		}while(flag != 7);
		
	}
	


}

