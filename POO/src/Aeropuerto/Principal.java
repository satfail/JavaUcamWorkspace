package Aeropuerto;

import java.util.Scanner;

public class Principal {
	
	static Scanner  entrada = new Scanner(System.in); 
	final static int NUM_AER = 4;
	static Aeropuerto[] aeropuertos = new Aeropuerto[NUM_AER];
	
	
	public static void main(String[] args) {
		insertarDatosAer(aeropuertos);
		menu();
	}
	
	public static void menu() {
		int opcion = 0;
		String nombreAeropuerto;
		Aeropuerto auxAeropuerto = null;
		String nombreCia = null;
		Companya auxCia = null;
		String auxOrigen = null;
		String auxDestino = null;
		do {
			
			System.out.println("\t MENU");
			System.out.println(" 1. Listar Aeropuertos");
			System.out.println(" 2. Ver Subvenciones o Empresas Patrocinadoras");
			System.out.println(" 3. Listar companyas de un Aeropuerto");
			System.out.println(" 4.  Listar Vuelos de una Companya");
			System.out.println(" 5. Mostrar todos los vuelos de Ciudad Origen a Destino");
			System.out.println(" 6. Salir\n");
			System.out.print(" Opcion : ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				mostrarAeropuertos(aeropuertos);
				break ;
			
			case 2: 
				mostrarPatrocinio(aeropuertos);
				break;
				
			case 3:
				entrada.nextLine();
				System.out.println("Cual es el nombre del Aeropuerto del que quiere saber las companyas");
				nombreAeropuerto = entrada.nextLine();
				auxAeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if(auxAeropuerto == null)
					System.out.println("El aeropuerto no existe");
				else 
					mostrarCia(auxAeropuerto);
				break;
				
			case 4:
				entrada.nextLine();
				System.out.println("Cual es el nombre del Aeropuerto del que quiere saber los vuelos");
				nombreAeropuerto = entrada.nextLine();
				auxAeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if(auxAeropuerto == null)
					System.out.println("El aeropuerto no existe");
				else {
					
					System.out.println("Introduzca el nombre de la cia : ");
					nombreCia = entrada.nextLine();
					auxCia = auxAeropuerto.getComp(nombreCia);
					mostrarVuelos(auxCia);
					
				}
					
				break;
				
			case 5:
				entrada.nextLine();
				System.out.println("Introduzca la ciudad Origen : ");
				auxOrigen = entrada.nextLine();
				System.out.println("Introduzca la ciudad Destino : ");
				auxDestino = entrada.nextLine();
				mostrarVueloOrigenDestino(auxOrigen, auxDestino, aeropuertos);
				
				break;
				
			case 6:
				System.out.println("Adios!");
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			System.out.println("");	
		}while(opcion !=6);
		
	}
	
	public static Vuelo[] buscarVuelos(String origen , String destino, Aeropuerto[] aero) {
		Vuelo auxVuelos = null;
		int contador = 0;
		Vuelo [] auxListaVuelos;
		
		//Cuento los vuelos que hay
		for (int i =0; i < aero.length; i++) { //Recorro aeropuestos
			for(int j = 0 ; j < aero[i].getNumcomp(); j++) {// Ahora las Cias
				for(int k = 0 ; k < aero[i].getComp(j).getNumVuelo() ; k++) { //Por ultimo los vuelos
					auxVuelos = aero[i].getComp(j).getVuelo(k);
					
					if ((origen.equals(auxVuelos.getCiudadOrigen())) && (destino.equals(auxVuelos.getCiudadDestino()))) {
						contador++;
					}
				}
			}
		}
		
		auxListaVuelos =new Vuelo[contador];
		int q = 0;
		//Guardo los datos, Se pudiera haber arreglado creando vectores y con add, esta bien en por practicar
		
		for (int i =0; i < aero.length; i++) { //Recorro aeropuestos
			for(int j = 0 ; j < aero[i].getNumcomp(); j++) {// Ahora las Cias
				for(int k = 0 ; k < aero[i].getComp(j).getNumVuelo() ; k++) { //Por ultimo los vuelos
					
					auxVuelos = aero[i].getComp(j).getVuelo(k);
					if ((origen.equals(auxVuelos.getCiudadOrigen())) && (destino.equals(auxVuelos.getCiudadDestino()))) {
						auxListaVuelos[q] = auxVuelos;
						q++;
					}
					}
				}
			}
		return auxListaVuelos;
	}

		
		

	public static void mostrarVueloOrigenDestino( String origen , String destino, Aeropuerto[] aero) {
		
		Vuelo [] vuelos = null;
		vuelos = buscarVuelos(origen, destino, aero);
		if(vuelos == null) {
			System.out.println("No existen vuelos ");
		}
		else {
			System.out.println("El vuelo con Origen en : " + origen + "  Destino en  : " + destino);
			System.out.println("");
			for(int i = 0; i < vuelos.length ; i++) {
				
				System.out.println("ID : " + vuelos[i].getIdentificador());
				System.out.println("Precio : " + vuelos[i].getPrecio());
				System.out.println("Numero Actual de Pasajeros : " + vuelos[i].getNumActualVuelo());
				System.out.println("Maximo de Pasajeros : " + vuelos[i].getNumMaxVuelo());
				System.out.println("");
			}
			
		}
		
		
		
	}
	
	public static void mostrarVuelos(Companya comp) {
		System.out.println("Los vuelos de la Companya son : " + comp.getNombre());
		for(int i = 0 ; i < comp.getNumVuelo(); i++) {
			System.out.println("ID : " + comp.getVuelo(i).getIdentificador());
			System.out.println("Ciudad de Origen : " + comp.getVuelo(i).getCiudadOrigen());
			System.out.println("Ciudad de Destino : " + comp.getVuelo(i).getCiudadDestino());
			System.out.println("Precui : " + comp.getVuelo(i).getPrecio());
		}
		
	}

	public static void mostrarCia (Aeropuerto aero) {
		
		System.out.println("Las companyas del Aeropuerto : " + aero.getNombre() + " son las siguientes : ");
		for (int i = 0;  i< aero.getNumcomp(); i++){
			System.out.println(aero.getComp(i).getNombre());
		}
	}
	
	public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto[] aero) {
		
		Aeropuerto auxAeropuerto = null;
		boolean encontrado = false;
		int i = 0;
		
		while((!encontrado)&& i < (aero.length)) {
			
			if (nombre.equals(aero[i].getNombre())) {
				
				auxAeropuerto = aero[i];
				encontrado = true;
			}
			i++;
		}
		
		return auxAeropuerto;
	}
	
	public static void mostrarPatrocinio(Aeropuerto[] aereo) {
		
		String empresas[];
		
		for (int i = 0; i < aereo.length; i++) {
			
			if (aereo[i] instanceof AeropuertoPrivado) {
				
				System.out.println("Aereo Privado : " + aereo[i].getNombre());
				empresas = ((AeropuertoPrivado)aereo[i]).getListaEmpresas();	
				System.out.println("Las empresas son : " );
				for (int j =0 ; j < empresas.length; j++) {
					System.out.println(empresas[j]);
				}
				
			}
			else {
				System.out.println("Aerepuerto Publico : " + aereo[i].getNombre());
				System.out.println("Subvencion : " + ((AeropuertoPublico)aereo[i]).getSubvencion());
				
			}
			System.out.println("");
		}
	}
	
	public static void mostrarAeropuertos(Aeropuerto[] aero) {
		
		for (int i = 0 ; i <aero.length; i++) {
			
			if( aero[i] instanceof AeropuertoPrivado) { ///DETERMINA SI ES DE ESA SUBCLASE!!!
				System.out.println("AeropuertoPrivado");
				System.out.println("Nombre : " + aero[i].getNombre() );
				System.out.println("Ciudad : " + aero[i].getCiudad());
				System.out.println("Pais : " + aero[i].getPais() );
			}
			
			else {
				System.out.println("Aeropuerto Publico");
				System.out.println("Nombre : " + aero[i].getNombre() );
				System.out.println("Ciudad : " + aero[i].getCiudad());
				System.out.println("Pais : " + aero[i].getPais() );
				
			}
			System.out.println("");
		}
		
	}

	public static void insertarDatosAer(Aeropuerto[] aero) {
		
		aero[0] = new AeropuertoPublico("Barajas", "Madrid", "Espanya", 8000000);
		aero[0].insertarComp(new Companya("Ryanair"));
		aero[0].insertarComp(new Companya("AirEuropa"));
		System.out.println(aero[0].getComp(1).getNombre());
		aero[0].getComp("Ryanair").insertarVuelo(new Vuelo("IB20", "Madrid", "Pekin", 2100, 150));
		aero[0].getComp("Ryanair").insertarVuelo(new Vuelo("IB20", "Madrid", "Pekin", 2300, 180));
		aero[0].getComp("AirEuropa").insertarVuelo(new Vuelo("IC20", "Madrid", "Pekin", 2300, 180));
		aero[0].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "Espanya", "AB232"));
		aero[0].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "Espanya", "CB232"));
		aero[0].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Lucas", "Espanya", "QW232"));
		aero[0].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Carmen", "Espanya", "ZX232"));
		
		aero[1] = new AeropuertoPublico("Extremadura XI", "Badajoz", "Espanya", 1000000);
		aero[1].insertarComp(new Companya("Ryanair"));
		aero[1].insertarComp(new Companya("AirEuropa"));
		aero[1].getComp("Ryanair").insertarVuelo(new Vuelo("IB20", "Badajoz", "Pekin", 2100, 150));
		aero[1].getComp("AirEuropa").insertarVuelo(new Vuelo("IC20", "Badajoz", "Tokio", 2703, 175));
		aero[1].getComp("AirEuropa").insertarVuelo(new Vuelo("IC21", "Badajoz", "Barcelona", 330, 175));
		aero[1].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "Espanya", "AB232"));
		aero[1].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "Espanya", "CB232"));
		aero[1].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Lucas", "Espanya", "QW232"));
		aero[1].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Carmen", "Espanya", "ZX232"));
		
		aero[2] = new AeropuertoPublico("Sevilla XI", "Sevilla", "Espanya", 5000000);
		aero[2].insertarComp(new Companya("Ryanair"));
		aero[2].insertarComp(new Companya("AirEuropa"));
		aero[2].getComp("Ryanair").insertarVuelo(new Vuelo("IB20", "Sevilla", "Pekin", 2100 ,150));
		aero[2].getComp("AirEuropa").insertarVuelo(new Vuelo("IC20", "Sevilla", "Tokio", 2703 ,175));
		aero[2].getComp("AirEuropa").insertarVuelo(new Vuelo("IC21", "Sevilla", "Barcelona", 330, 175));
		aero[2].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "Espanya", "AB232"));
		aero[2].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "Espanya", "CB232"));
		aero[2].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Lucas", "Espanya", "QW232"));
		aero[2].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Carmen", "Espanya", "ZX232"));
		
		aero[3] = new AeropuertoPrivado("Barcelona XIII", "Barcelona", "ModernDonia");
		String empresas[] = {"CocaCola", "CDR"};
		((AeropuertoPrivado)aero[3]).insertarEmpresas(empresas); //Downcasting y uso metodo
		aero[3].insertarComp(new Companya("Ryanair"));
		aero[3].insertarComp(new Companya("AirEuropa"));
		aero[3].getComp("Ryanair").insertarVuelo(new Vuelo("IB20", "Barcelona", "ModernDonia", 2100, 150));
		aero[3].getComp("AirEuropa").insertarVuelo(new Vuelo("IC20", "Barcelona", "ModernDonia", 2703., 175));
		aero[3].getComp("AirEuropa").insertarVuelo(new Vuelo("IC21", "Barcelona", "ModernDonia", 330, 175));
		aero[3].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "Espanya", "AB232"));
		aero[3].getComp("Ryanair").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "Espanya", "CB232"));
		aero[3].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Lucas", "Espanya", "QW232"));
		aero[3].getComp("AirEuropa").getVuelo("IC20").insertarPasajero(new Pasajero("Carmen", "Espanya", "ZX232")); 
	}
}
