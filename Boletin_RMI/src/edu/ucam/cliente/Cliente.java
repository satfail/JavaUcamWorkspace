package edu.ucam.cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import edu.ucam.estructuraclases.Expediente;
import edu.ucam.estructuraclases.Paciente;
import edu.ucam.interfacePaciente.Hospital;

//Fallos cometidos y a tener en cuenta para el examen
	//Si hago el metodo de listar y llamo al objeto con el proxy listo en el servidor!!!
	//Creo un metodo que me traiga la lista y la listo en el cliente

public class Cliente {
	
	public static void main(String[] args) {
		
		try {
			///Creo el objeto con el proxy para el manejo de objetos en el servidor
			
			Hospital hospital = (Hospital)Naming.lookup("rmi://localhost:1099/HospitalCentral");
			
			menu(hospital);

			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Paciente datosPaciente() {
		Paciente p= new Paciente();
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduzca nombre : ");p.setNombre(entrada.nextLine());
		System.out.print("Introduzca Apellido : ");p.setApellidos(entrada.nextLine());
		System.out.print("Introduzca DNI : ");p.setDni(entrada.nextLine());
		return p;
	}
	
	public static Expediente datosExpediente() {
		Paciente p= new Paciente();
		Expediente ex = new Expediente();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Datos del Paciente ");
		System.out.print("Introduzca nombre : ");p.setNombre(entrada.nextLine());
		System.out.print("Introduzca Apellido : ");p.setApellidos(entrada.nextLine());
		System.out.print("Introduzca DNI : ");p.setDni(entrada.nextLine());
		ex.setP(p);
		System.out.println("Datos del Expediente ");
		System.out.print("Introduzca Observaciones :"); ex.setObservaciones(entrada.nextLine());
		System.out.print("Introduzca Tratamiento :"); ex.setTratamiento(entrada.nextLine());
	
		return ex;
	}
	
	public static void menu(Hospital hospital) {
		
		boolean  flag = false;
		Scanner entrada = new Scanner(System.in);
		int valorMenu = 0;
		int index;
		texto();
		do {
			try {
				System.out.print("> ");
				valorMenu = entrada.nextInt();
				switch (valorMenu) {
				case 1:
					hospital.addPaciente(datosPaciente());
					break;
				case 2:
					listarPacientes(hospital);
					System.out.print("Introduzca el indice donde se encuentra el paciente a modificar : ");
					index = entrada.nextInt();
					hospital.updatePaciente(datosPaciente(), index);
					break;
				case 3:
					listarPacientes(hospital);
					System.out.print("Introduzca el indice donde se encuentra el paciente a borrar : ");
					index = entrada.nextInt();
					hospital.removePaciente(index);
					break;
				case 4:
					listarPacientes(hospital);
					break;
				case 5:
					hospital.addExpediente(datosExpediente());
					break;
				case 6:
					listarExpediente(hospital);
					System.out.print("Introduzca el indice donde se encuentra el expediente a modificar : ");
					index = entrada.nextInt();
					hospital.updateExpediente(datosExpediente(), index);
					break;
				case 7:
					listarExpediente(hospital);
					System.out.print("Introduzca el indice donde se encuentra el expediente a borrar : ");
					index = entrada.nextInt();
					hospital.removeExpediente(index);
					break;
				case 8:
					listarExpediente(hospital);
					break;
				case 9:
					texto();
					break;			
					case 10:
						flag = true;
						break;
				default:
					System.err.println("Valor de menu incorrecto ([1-10])");
					break;
				}
			
			}	catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} while (!flag);
		
		
	}
	
	
	private static void texto() {
		
		System.out.println("*****MENU PACIENTE******");
		System.out.println( " 1. ADDPACIENTE ");
		System.out.println( " 2. UPDATEPACIENTE ");
		System.out.println( " 3. REMOVEPACIENTE ");
		System.out.println( " 4. LISTPACIENTE ");
		
		
		System.out.println("*****MENU EXPEDIENTE******");
		System.out.println( " 5. ADDEXPEDIENTE ");
		System.out.println( " 6. UPDATEEXPEDIENTE ");
		System.out.println( " 7. REMOVEEXPEDIENTE ");
		System.out.println( " 8. LISTEXPEDIENTE ");
		
		System.out.println("*****************************");
		System.out.println( " 9. HELP ");
		System.out.println( " 10. SALIR ");

		
	}
	
	public static void listarPacientes(Hospital hospital) throws RemoteException {
		
		for(Map.Entry<Integer, Paciente> p : hospital.getListaPacientes().entrySet()) {
			System.out.println("ID : " + p.getKey() + " DNI : " + p.getValue().getDni() +
					" Nombre: "+ p.getValue().getNombre());
		}
	}
	
	public static void listarExpediente(Hospital hospital) throws RemoteException {
		for(Map.Entry<Integer, Expediente> ex : hospital.getListaExpedientes().entrySet()) {
			System.out.println("IDEXPEDIENTE : " + ex.getKey() + " DNI : " + ex.getValue().getP().getDni() +
					" Nombre: "+ ex.getValue().getP().getNombre());
			System.out.println("Observaciones :" + ex.getValue().getObservaciones() + 
					" Tratamiento " + ex.getValue().getTratamiento());
			System.out.println("----------------------------------");
	}

		}
}


