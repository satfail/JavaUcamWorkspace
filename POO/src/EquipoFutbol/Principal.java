package EquipoFutbol;

import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
	
	static ArrayList<Persona> persona = new ArrayList<Persona>();
	static Scanner entrada = new Scanner(System.in);
	static Persona futbolista = new Futbolista("Cristiano", "Ronaldo", 32, 7, "Delantero");
	static Persona futbolista2 = new Futbolista("Paulo", "Dibala", 23, 21, "Delantero");
	static Persona entrenador = new Entrenador("Maximiliano", "Alegri",42,"Defensiva");
	static Persona medico = new Medico("Juan","Gaman",32,"Fisioterapia",7);
	
	public static void main(String[] args) {

		
		persona.add(futbolista);
		persona.add(futbolista2);
		persona.add(entrenador);
		persona.add(medico);
		
		menu();
		
		
		
	}
	
	public static void menu() {
		int opcion = 0;
		do {
			
			System.out.println("\t Menu ");
			System.out.println(" 1. Viaje de Equipo");
			System.out.println(" 2. Entrenamiento");
			System.out.println(" 3. Partido de Futbol");
			System.out.println(" 4. Planificar Entrenamiento");
			System.out.println(" 5. Entrevista");
			System.out.println(" 6. Curar Lesion");
			System.out.println(" 7. Salir");
			opcion = entrada.nextInt();
			
			
			switch (opcion) {
			case 1:
				for (Persona p : persona) {
					System.out.println("Nombre : "+ p.getNombre() + " Apellidos : " + p.getApellidos() );
					p.viajar();
				}
				break;
				
			case 2: 
				for (Persona p : persona) {
					System.out.println("Nombre : "+ p.getNombre() + " Apellidos : " + p.getApellidos() );
					p.entrenamiento();
				}
				break;
				
			case 3:
				for (Persona p : persona) {
					System.out.println("Nombre : "+ p.getNombre() + " Apellidos : " + p.getApellidos() );
					p.partidoFutbol();
				}
				
				break;
				
			case 4 :
			
					System.out.println("Nombre : "+ entrenador.getNombre() + " Apellidos : " + entrenador.getApellidos() );
					//Downcasting para transformar la clase persona y poder utilizar el metodo del entrenador
					((Entrenador)entrenador).planificarEntrenamiento();		
				break;
				
			case 5:
				System.out.println("Nombre : "+ futbolista.getNombre() + " Apellidos : " + futbolista.getApellidos() );
				((Futbolista)futbolista).entrevista();
				System.out.println("Nombre : "+ futbolista2.getNombre() + " Apellidos : " + futbolista2.getApellidos() );
				((Futbolista)futbolista2).entrevista();
				
				break;
				
			case 6:
				//En el syso no hace falta el down casting xk son variables de la superclase persona
				System.out.println("Nombre : "+ medico.getNombre() + " Apellidos : " + medico.getApellidos() );
				((Medico)medico).curarLesion();
				
				break;
				
			case 7:
				System.out.println(" 1Adios");
				break;

			default:
				throw new IllegalArgumentException(" Unexpected value: " + opcion);
			}
		}while(opcion != 7);
	}

}
