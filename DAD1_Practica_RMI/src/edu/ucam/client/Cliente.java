package edu.ucam.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import edu.ucam.application.Hospital;
import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
import edu.ucam.pojos.Tratamiento;




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
		Paciente paciente= new Paciente();
		Scanner entrada = new Scanner(System.in);
		String dateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Introduzca nombre : ");paciente.setNombre(entrada.nextLine());
		System.out.print("Introduzca Apellido : ");paciente.setApellidos(entrada.nextLine());
		System.out.print("Introduzca Fecha Nacimiento (dd/mm/yyyy): "); dateString = entrada.nextLine();
		try {
			paciente.setFechaNacimiento(sdf.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return paciente;
	}
	
	public static Medico datosMedico() {
		Medico medico= new Medico();
		Scanner entrada = new Scanner(System.in);

		System.out.print("Introduzca Nombre : ");medico.setNombre(entrada.nextLine());
		System.out.print("Introduzca Apellido : ");medico.setApellidos(entrada.nextLine());
		System.out.print("Introduzca Especialidad :");medico.setEspecialidad(entrada.nextLine());
		return medico;
	}
	public static Expediente expedienteVacio() {
		Expediente expediente = new Expediente();
		return expediente;
	}
	
	public static Tratamiento datosTratamiento() {
		Tratamiento tratamiento= new Tratamiento();
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduzca Descripcion : ");tratamiento.setDescripcion(entrada.nextLine());
		return tratamiento;
	}

	
	public static Expediente datosExpediente() {
		Paciente paciente= new Paciente();
		Expediente expediente = new Expediente();
		Tratamiento tratamiento = new Tratamiento();
		Scanner entrada = new Scanner(System.in);
		String dateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Datos del Paciente ");
		System.out.print("Introduzca nombre : ");paciente.setNombre(entrada.nextLine());
		System.out.print("Introduzca Apellido : ");paciente.setApellidos(entrada.nextLine());
		System.out.print("Introduzca Fecha Nacimiento (dd/mm/yyyy): "); dateString = entrada.nextLine();
		try {
			paciente.setFechaNacimiento(sdf.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Datos del Expediente ");
		System.out.print("Introduzca Observaciones :"); expediente.setObservaciones(entrada.nextLine());
		System.out.print("Introduzca Tratamiento :"); tratamiento.setDescripcion(entrada.nextLine());
		expediente.setTramientos(new ArrayList<Tratamiento>());
		expediente.getTramientos().add(tratamiento);
		expediente.setPaciente(paciente);
		return expediente;
	}
	
	public static void menu(Hospital hospital) {
		
		boolean  flag = false;
		Scanner entrada = new Scanner(System.in);
		String valorMenu = "";
		int index, indexExpediente;
		texto();
		do {
			try {
				//System.out.print("Introduzca una tecla para continuar");
				//entrada.nextLine();
				System.out.print("> ");
				valorMenu = entrada.nextLine();
				switch (valorMenu) {
				case "ADDPACIENTE":
					if(hospital.addPaciente(datosPaciente()))
						System.out.println("Paciente Creado");
					else {
						System.err.println("Error al crear el Paciente");
					}
					break;
				case "UPDATEPACIENTE":
					listarPacientes(hospital);
					System.out.print("Introduzca el indice donde se encuentra el paciente a modificar : ");
					index = entrada.nextInt();
					if(hospital.updatePaciente(datosPaciente(), index))
						System.out.println("Paciente Modificado");
					else
						System.err.println("Error al modificar el Paciente");
					break;
				case "GETPACIENTE":
					Paciente paciente = null;
					System.out.print("Introduzca el indice del paciente : ");
					index = entrada.nextInt();
					paciente = hospital.getPaciente(index);
					if (paciente != null) {
						System.out.println(" Nombre: "+ paciente.getNombre() + " " +
						paciente.getApellidos()+" Fecha Nacimiento : " + paciente.getFechaNacimiento());
					}else {
						System.err.println("Paciente no encontrado");
					}
					break;
				case "REMOVEPACIENTE":
					listarPacientes(hospital);
					System.out.print("Introduzca el indice donde se encuentra el paciente a borrar : ");
					index = entrada.nextInt();
					hospital.removePaciente(index);
					break;
				case "LISTPACIENTE":
					listarPacientes(hospital);
					break;
				case "ADDEXPEDIENTE":
					if(hospital.addExpediente(expedienteVacio()))
						System.out.println("Expediente vacio creado");
					else {
						System.err.println("Error al crear el Expediente");
					}
					break;
					
				case "GETEXPEDIENTE":
					Expediente expediente = null;
					System.out.print("Introduzca el indice del paciente : ");
					index = entrada.nextInt();
					expediente = hospital.getExpediente(index);
					if (expediente != null) {
						System.out.println("Paciente : " + expediente.getPaciente().getNombre() + 
								" " +expediente.getPaciente().getApellidos() +
								"\nMedico : " + expediente.getMedico().getNombre() + " " +  expediente.getMedico().getApellidos()+
								" Especialidad : " +expediente.getMedico().getEspecialidad() + 
								"\nTratamiento : ");
							for(Tratamiento tratamientos : expediente.getTramientos()) {
								System.out.println(tratamientos.getDescripcion());
							}
					}else {
						System.err.println("Expediente no encontrado");
					}
					break;
				case "UPDATEEXPEDIENTE":
					listarExpediente(hospital);
					System.out.print("Introduzca el indice donde se encuentra el expediente a modificar : ");
					index = entrada.nextInt();
					if(hospital.updateExpediente(datosExpediente(), index))
						System.out.println("Expediente Modificado");
					else {
						System.err.println("Error al modificar el Expediente");
					}
					break;
				case "REMOVEEXPEDIENTE":
					listarExpediente(hospital);
					System.out.print("Introduzca el indice donde se encuentra el expediente a borrar : ");
					index = entrada.nextInt();
					hospital.removeExpediente(index);
					break;
					
				case "ADDPACIENTE2EXP":
					listarPacientes(hospital);
					System.out.println("Introduzca el ID del paciente al que quiere insertar");
					index = entrada.nextInt();
					System.out.println("Introduzca el Expediente al que quiere insertar el Paciente");
					indexExpediente = entrada.nextInt();
					if(hospital.addPaciente2Exp(index, indexExpediente))
						System.out.println("Paciente introducido");
					else {
						System.out.println("Error al introducir el Paciente");
					}
					break;
					
				case "ADDMEDICO2EXP":
					listarMedicos(hospital);
					System.out.println("Introduzca el ID del medico al que quiere insertar");
					index = entrada.nextInt();
					System.out.println("Introduzca el Expediente al que quiere insertar el Paciente");
					indexExpediente = entrada.nextInt();
					if(hospital.addMedico2Exp(index, indexExpediente))
						System.out.println("Medico Introducido");
					else
						System.out.println("Error al introducir el Medico");
					break;
					
				case "ADDTRATAM2EXP":	
					System.out.println("Introduzca el ID del Expediente al que quiere insertar el Tratamiento");
					indexExpediente = entrada.nextInt();
					if(hospital.addTratam2Exp(datosTratamiento(), indexExpediente))
						System.out.println("Tratamiento introducido");
					else {
						System.out.println("Error al introducir el Tratamiento");
					}
				
				break;
				
				case "REMOVEPACIENTEFROMEXP":
					listarPacientes(hospital);
					System.out.println("Introduzca el ID Expediente al que quiere borrar el Paciente");
					indexExpediente = entrada.nextInt();
					if(hospital.removePacienteFROMExp(indexExpediente))
						System.out.println("Paciente borrado del Expediente");
					else
						System.err.println("Error al borrar el Paciente del Expediente");
					break;
				case "REMOVEMEDICOFROMEXP":
					listarMedicos(hospital);
					System.out.println("Introduzca el ID Expediente al que quiere borrar el Medico");
					indexExpediente = entrada.nextInt();
					if(hospital.removedMedicoFROMExp( indexExpediente))
						System.out.println("Medico borrado del Expediente ");
					else
						System.err.println("Error al Borrar el Medico del Expediente");
					break;
					
				case "REMOVETRATAMFROMEXP":
					System.out.println("Introduzca el Expediente al que quiere borrar el Tratamiento");
					indexExpediente = entrada.nextInt();
					if(hospital.removeTratamFROMExp(indexExpediente))
						System.out.println("Tratamiento borrado del Expediente");
					else
						System.err.println("Error al borrar el Tratameinto del Expediente");
					break;
					
				case "ADDMEDICO":
					if(hospital.addMedico(datosMedico()))
						System.out.println("Medico insertado");
					else {
						System.err.println("Error al insertar el Medico");
					}
					break;
					
				case "GETEMEDICO":
					Medico medico = null;
					System.out.print("Introduzca el indice del paciente : ");
					index = entrada.nextInt();
					medico = hospital.getMedico(index);
					if (medico != null) {
						System.out.println("Nombre : " + medico.getNombre()+ " " +
								medico.getApellidos() + " Especialidad: "+ medico.getEspecialidad());
					}else {
						System.err.println("Expediente no encontrado");
					}
					break;
				case "UPDATEMEDICO":
					listarMedicos(hospital);
					System.out.print("Introduzca el indice donde se encuentra el Medico a modificar : ");
					index = entrada.nextInt();
					if(hospital.updateMedico(datosMedico(), index))
						System.out.println("Medico modificado");
					else
						System.err.println("Error al modificar el Medico");
					break;
				case "REMOVEMEDICO":
					listarMedicos(hospital);
					System.out.print("Introduzca el indice donde se encuentra el Medico a borrar : ");
					index = entrada.nextInt();
					hospital.removeMedico(index);
					break;
				case "LISTMEDICO":
					listarMedicos(hospital);
					break;	
				case "LISTEXPEDIENTE":
						listarExpediente(hospital);
					break;
				case "HELP":
					texto();
					break;			
					case "EXIT":
						flag = true;
						break;
				default:
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
		System.out.println( " 3. GETPACIENTE ");
		System.out.println( " 4. REMOVEPACIENTE ");
		System.out.println( " 5. LISTPACIENTE ");
		
		
		System.out.println("*****MENU EXPEDIENTE******");
		System.out.println( " 6. ADDEXPEDIENTE ");
		System.out.println( " 7. UPDATEEXPEDIENTE ");
		System.out.println( " 8. GETEXPEDIENTE ");
		System.out.println( " 9. REMOVEEXPEDIENTE ");
		System.out.println( " 10. ADDPACIENTE2EXP ");
		System.out.println( " 11. ADDMEDICO2EXP ");
		System.out.println( " 12. ADDTRATAM2EXP ");
		System.out.println( " 13. REMOVEPACIENTEFROMEXP ");
		System.out.println( " 14.REMOVEMEDICOFROMEXP ");
		System.out.println( " 15. REMOVETRATAMFROMEXP ");
		System.out.println( " 16. LISTEXPEDIENTE ");
		
		
		System.out.println("*****MENU MEDICOS******");
		System.out.println( " 17. ADDMEDICO ");
		System.out.println( " 18. UPDATEMEDICO ");
		System.out.println( " 19. GETMEDICO ");
		System.out.println( " 20. REMOVEMEDICO ");
		System.out.println( " 21. LISTMEDICO ");
		
		System.out.println("*****************************");
		System.out.println( " 22. HELP ");
		System.out.println( " 23. EXIT ");

		
	}
	
	
	public static void listarPacientes(Hospital hospital) throws RemoteException {
		
		for(Map.Entry<Integer, Paciente> paciente : hospital.getListaPacientes().entrySet()) {
			System.out.println("ID : " + paciente.getKey() +" Nombre: "+ paciente.getValue().getNombre() + " " +
			paciente.getValue().getApellidos()+" Fecha Nacimiento : " + paciente.getValue().getFechaNacimiento());
		}
	}
	
	
	public static void listarMedicos(Hospital hospital) throws RemoteException {
		
		for(Map.Entry<Integer, Medico> medico : hospital.getListaMedico().entrySet()) {
			System.out.println("ID : " + medico.getKey() + " Nombre : " + medico.getValue().getNombre()+ " " +
					medico.getValue().getApellidos() + " Especialidad: "+ medico.getValue().getEspecialidad());
		}
	}
	
	public static void listarExpediente(Hospital hospital) throws RemoteException {
		
		
		for(Map.Entry<Integer, Expediente> e : hospital.getListaExpedientes().entrySet()) {
			try {
				System.out.println("-----------------------------------------------");
				System.out.println( "ID : " +  e.getKey() + "\nPaciente : " + e.getValue().getPaciente().getNombre() + 
					" " +e.getValue().getPaciente().getApellidos() +
					"\nMedico : " + e.getValue().getMedico().getNombre() + " " + e.getValue().getMedico().getApellidos()+
					" Especialidad : " + e.getValue().getMedico().getEspecialidad() + 
					"\nTratamiento : ");
				for(Tratamiento tratamientos : e.getValue().getTramientos()) {
					System.out.println(tratamientos.getDescripcion());
				}

			}catch (NullPointerException eNullPointerException) {
				System.out.println("ID : " + e.getKey() +" Datos de Expediente Incompletos");
			}
		}
		
	}
}


