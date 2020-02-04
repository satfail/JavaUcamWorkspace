package edu.ucam.crud;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import edu.ucam.aplicacion.Automovil;
import edu.ucam.aplicacion.Cliente;
import edu.ucam.aplicacion.Comercial;
import edu.ucam.aplicacion.Jefe;
import edu.ucam.aplicacion.Mecanico;
import edu.ucam.aplicacion.Moto;
import edu.ucam.aplicacion.Persona;
import edu.ucam.aplicacion.Trabajo;
import edu.ucam.aplicacion.Turismo;

public class TallerSingleton {
	
	private static TallerSingleton instanciaTaller = null;
	private static TreeMap<String, Persona> personas = new TreeMap<String, Persona>();
	private static TreeMap<String, Trabajo> trabajos = new TreeMap<String, Trabajo>();
	private static HashMap<String, Automovil> automoviles = new HashMap<String, Automovil>();
	private static Scanner entrada = new Scanner(System.in);
	private int contadorPersona = 0;
	private int contadorTrabajo = 0;
	private String filePersona= "data/persona.data";
	private static String id = "";
	
	//Uso de Modelo Singleton
	
	private TallerSingleton() {}
	
	public static TallerSingleton getTallerSingleton() {
		
		if(instanciaTaller == null) {
			instanciaTaller = new TallerSingleton();
			}
		
		return instanciaTaller;
	}
	
	
	
							/*Metodos Persona*/
	public TreeMap<String, Persona> getPersonas() {
		return personas;
	}
	
	public void addCliente() {
		Persona p = entradaCliente();
		personas.put(getKey(p), p);	
	}
	
	public Persona buscarPersona() {
		Persona p= null;
		System.out.println("Pulse una tecla para continuar...");
		entrada.nextLine(); ///Quitar error de buffer
		System.out.print("Introduzca la id de la persona a buscar : ");
		id = entrada.nextLine();
		p = personas.get(id);
		if(p == null)
			System.err.println("La persona no se encuentra en el sistema");
		else {
			System.out.println("Persona encontada : " + p);
		}
		return p; 
	}

	public void eliminarCliente() {
		generarInformeClientes();
		System.out.println("Pulse una tecla para continuar...");
		entrada.nextLine();
		System.out.print("Introduzca el ID que quiere borrar : ");
		String idBorrar = entrada.nextLine();
		Persona pBorrada = personas.remove(idBorrar);
		if (pBorrada == null) {
			System.out.println("No se pudo borrar el cliente seleccionado");
		}
		else {
			System.out.print("Se borro a : " + pBorrada);
		}

		
	}
	
	public void generarInformePersonal() {
		//Ligadura Dinámica
        for(Entry<String, Persona> p: personas.entrySet()) {
        	
        	if(p.getValue() instanceof Jefe ) {
        		System.out.println("ID: " + p.getKey() +" " +(Jefe)p.getValue());
        		}
        	else if(p.getValue() instanceof Mecanico ) {

        		System.out.println("ID: " + p.getKey() +" " +(Mecanico)p.getValue());
        		}
        	else if(p.getValue() instanceof Comercial ) {

        		System.out.println("ID: " + p.getKey() +" " +(Comercial)p.getValue());
        		}
        	else if(p.getValue() instanceof Cliente ) {

        		System.out.println("ID: " + p.getKey() +" " +(Cliente)p.getValue());
        		}
        }
			
		}
	
	public void generarInformeClientes() {
		
        for(Entry<String, Persona> p: personas.entrySet()) {

        	if(p.getValue() instanceof Cliente ) {
        		System.out.println("ID: " + p.getKey() +" " + p.getValue().toString());
        		}
        }
			
		}
	
	public static boolean getDNIbyID(String id) {
		boolean resultado = false;
		for(Entry<String, Persona> p: personas.entrySet()) {
			if(p.getKey().equals(id)) {
				resultado = true;
			}
		}
		return resultado;
		
	}
	
	public void leerDatos () {

		try {
			
		  FileInputStream file = new FileInputStream 
	                (filePersona); 
	        ObjectInputStream in = new ObjectInputStream 
	                (file); 
	        personas = (TreeMap<String, Persona>)in.readObject();
	        
	        file.close();
	        in.close();
	        this.contadorPersona = personas.size();
		}catch (IOException  | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void guardarDatos() {
		try {
			
            FileOutputStream file = new FileOutputStream 
                    (filePersona); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            out.writeObject(personas);
            out.close(); 
            file.close(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static TreeMap<String, Trabajo> getTrabajos() {
		return trabajos;
	}
	
	public void addTrabajo(TreeMap<String, Persona> personas) { ///Probar entry 
		Trabajo trab1 = entradaTrabajo();
		trabajos.put(getKey(trab1), trab1);	 
	}
	
	public void eliminarTrabajo() {
		generarInformeTrabajos();
		System.out.println("Pulse una tecla para continuar...");
		entrada.nextLine();
		System.out.print("Introduce el id que quieres eliminar : ");
		id = entrada.nextLine();
		Trabajo trabajoBorrado = trabajos.remove(id);

		if(trabajoBorrado == null)
			System.err.println("El trabajo no se ha borrado correctamente");
		else {
			System.out.println("Se ha borrado el trabajo : ");
			
		}
	}
	
	public void generarInformeTrabajos() {
		for(Entry<String, Trabajo> t: trabajos.entrySet()) {
			System.out.println(" "+ t.toString());
		}
	}
	
	public Trabajo buscarTrabajo() {
		Trabajo trabajoBuscado = null;
		System.out.println("Pulse una tecla para continuar...");
		entrada.nextLine();
		System.out.print("Introduzca la id del trabajo a buscar : ");
		id = entrada.nextLine();
		trabajoBuscado = trabajos.get(id);
		if(trabajoBuscado == null)
			System.err.println("El trabajo no se encuentra en el sistema");
		else {
			System.out.println("Trabajo encontado : " + trabajoBuscado);
		}
		return trabajoBuscado; 
	}
	
	public void finalizarTrabajo() {
		System.out.print("Pulse una tecla para continuar... ");
		entrada.nextLine();
		System.out.print("Introduzca el Trabajo que ha finalizado : ");
		id = entrada.nextLine();
		
		if(trabajos.get(id).getMecanico() == null) {
			System.err.println("Ese trabajo no tiene asignado ningun mecanico");
		}else {

			trabajos.get(id).setFin(new Date(System.currentTimeMillis())); 
			trabajos.get(id).setPrecio();
			((Mecanico)trabajos.get(id).getMecanico()).setEstadoTrabajando(false);
			((Automovil)trabajos.get(id).getAuto()).setTipoAveria("");
			((Automovil)trabajos.get(id).getAuto()).setEstadoReparacion("finalizado");;
		}
	
	}
	
	public void visitasModeloThisYear() {
		String marca = "";
		Date fechaActual = new Date(System.currentTimeMillis());
		System.out.print("Introduzca el modelo que quiere buscar : ");
		marca = entrada.nextLine();
		try {
		for(Entry<String, Trabajo> t: trabajos.entrySet()) {
			if(t.getValue().getInicio().getYear() == fechaActual.getYear() &&
					t.getValue().getAuto().getMarca().equals(marca)) {
				System.out.println(t.toString());
			}
		}	
		}catch (NullPointerException e) {
			System.err.println("El vehiculo no existe");
		}
	}
	
	public void expedienteCliente() { //Funciona
		System.out.println("Introduzca la ID del cliente que quiere buscar : ");
		String idCliente = entrada.nextLine();
		ArrayList<Trabajo> trabajoCliente = new ArrayList<Trabajo>();
		for(Entry<String, Trabajo> t: trabajos.entrySet()) {
				trabajoCliente.add(t.getValue());	
		}
		//Comparator
		Collections.sort(trabajoCliente, new Comparator<Trabajo>() {

			@Override 
			public int compare(Trabajo o1, Trabajo o2) {
				int resultado = 0;
				if(o1.getInicio().getTime()>= o2.getInicio().getTime())
					resultado = 1;
				return resultado;
				
			}
		});
		
		for(Entry<String, Trabajo> t: trabajos.entrySet()) {
			if(((Cliente)t.getValue().getCliente()).getIdCliente().contains(idCliente)) {
					System.out.println(((Cliente)t.getValue().getCliente()).getIdCliente() + " - " +
							((Cliente)t.getValue().getCliente()).toString() + "\nVehiculo -" + 
							((Cliente)t.getValue().getCliente()).getAuto().toString() 	);
				
					System.out.println("Trabajo - Inicio : " + t.getValue().getInicio()+ " Mecanico : " + t .getValue().getMecanico().getNombre()+
							" Estado : " +t.getValue().getAuto().getTipoAveria());
					
					if(t.getValue().getPrecio() != 0.0f)
						System.out.println(t.getValue().getPrecio());
					
					System.out.println("");
			}
		}
		
	}
	
	public void guardarTrabajos() {
		String fileTrabajos= "data/trabajo.data";
		try {
			
            FileOutputStream file = new FileOutputStream 
                    (fileTrabajos); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            out.writeObject(trabajos);
            out.close(); 
            file.close(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void leerTrabajos() {
		
		String fileTrabajos= "data/trabajo.data";
		//Manejo de Extensiones
		try {
			
		  FileInputStream file = new FileInputStream 
	                (fileTrabajos); 
	        ObjectInputStream in = new ObjectInputStream 
	                (file); 
	        trabajos = (TreeMap<String, Trabajo>)in.readObject();
	        contadorTrabajo = trabajos.size();
	        file.close();
	        in.close();

		}catch (IOException  | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void   leerDatosAuto(){
		String fileAuto = "data/autos.data";
		try {
			
	        FileInputStream file2 = new FileInputStream 
	                (fileAuto); 
	        ObjectInputStream in = new ObjectInputStream 
	                (file2); 
	        automoviles = (HashMap<String, Automovil>)in.readObject();
	        file2.close();
	        in.close();
			
		} catch (IOException | ClassNotFoundException e) {
			if(e instanceof IOException)
				System.err.println("No se ha podido encontrar el archivo");
			else {
				System.err.println("No se ha podido leer el archivo");
			}
		}

	}
	
	public Cliente entradaCliente() {
		System.out.println("Pulse una tecla para continuar...");
		entrada.nextLine();
		String nombre, apellido,dni;
		System.out.print("Introduzca nombre del cliente : ");
		nombre = entrada.nextLine();
		System.out.print("Introduzca apellido del cliente : ");
		apellido = entrada.nextLine();
		System.out.print("Introduzca dni del cliente : ");
		dni = entrada.nextLine();

		
		Cliente cliente = new Cliente(nombre, apellido, dni, entradaAutomovil() , id,  new Date(2019, 1, 1));
		return cliente;
	}
	
	public Automovil entradaAutomovil() {
		//Ejemplo manejo de Extensiones
		try {
			System.out.print("Pulse una tecla para continuar... ");
			entrada.nextLine();
			System.out.println("Que vehiculo posee Turismo(T) o Moto(M)");
			Automovil automovil = null;
			if (entrada.nextLine().equals("T")) {
				automovil = new Turismo(); 
				System.out.println("Introduzca marca"); automovil.setMarca(entrada.nextLine());
				System.out.println("Introduzca modelo"); automovil.setModelo(entrada.nextLine());
				System.out.println("Introduzca Matricula"); automovil.setMatricula(entrada.nextLine());
				System.out.println("Introduzca caballos"); automovil.setCaballos(entrada.nextInt());
				System.out.println("Introduzca capacidad"); ((Turismo)automovil).setCapacidad(entrada.nextFloat());
			}
			else {
				automovil = new Moto(); 
				System.out.println("Introduzca marca"); automovil.setMarca(entrada.nextLine());
				System.out.println("Introduzca modelo"); automovil.setModelo(entrada.nextLine());
				System.out.println("Introduzca Matricula"); automovil.setMatricula(entrada.nextLine());
				System.out.println("Introduzca caballos"); automovil.setCaballos(entrada.nextInt());
				System.out.println("Introduzca cilindrada"); ((Moto)automovil).setCilindrada(entrada.nextInt());
				return automovil;
			}
			return automovil;
		}catch (InputMismatchException e) {
			System.out.println("Error al introducir los campos");
			return null;
		}
		
	}
	
	public String getKey(Object o) {
		
		if (o instanceof Cliente) {
			do {
				contadorPersona++;
				id = "C"+contadorPersona;
			}while(personas.containsKey(id));
		}
		
		if (o instanceof Mecanico) {
			do {
				contadorPersona++;
				id = "M"+contadorPersona;
			}while(personas.containsKey(id));
		}
		if (o instanceof Jefe) {
			do {
				contadorPersona++;
				id = "J"+contadorPersona;
			}while(personas.containsKey(id));
		}
		if(o instanceof Trabajo) {
			do {
				contadorTrabajo++;
				id ="T"+contadorTrabajo;
				System.out.println(id);
			}while(trabajos.containsKey(id));
		}
		return id;

	}
	
	public void updateCliente() {
		
		Persona pBuscada = buscarPersona();
		Persona pNueva = null;
		String idBuscada = null;
		
		if(pBuscada instanceof Cliente) {
			
			for(Entry<String , Persona> p : personas.entrySet()) {
				if(p.getValue().getDni().equals(pBuscada.getDni())) {
					idBuscada = p.getKey();
				}
			}
			pNueva = (Cliente) entradaCliente();
			System.out.println("Introduzca la ID que quiere cambiar : ");
			
			if(personas.replace(idBuscada, pNueva) != null)
				System.out.println("Modificacion correcta");
			else {
				System.err.println("Error al modificar");
			}
			
		}else {
			System.err.println("Introduzca un Cliente valido");
		}
	
	}
	
	public Trabajo entradaTrabajo() {

		Cliente cliente = null;
		Mecanico mecanico = null;
		Turismo turismo = null;
		Moto moto =null;
		Trabajo trabajo = null;
		entrada.nextLine();
		System.out.println("Introduce la ID del cliente : ");
		id = entrada.nextLine();
		if(!personas.containsKey(id)) {
			System.out.println("Cliente no encontrado");
		}else {
				cliente = (Cliente)personas.get(id);
				System.out.println("El cliente es :" + cliente.toString());
			
			System.out.print("Desea Asignar un Mecanico ahora?  s/n : ");
			if(entrada.nextLine().equalsIgnoreCase("s")) {
				System.out.println("Introduce el ID del Mecanico que va a trabajar : ");
				id = entrada.nextLine();
				if(!(personas.containsKey(id))) {
					System.out.println("Mecanico no encontrado");
				}else {
					mecanico = (Mecanico)personas.get(id);
					mecanico.setEstadoTrabajando(true);
					System.out.println("El mecanico elegido es " +  mecanico.toString());
					
				}
				Date currentDate = new Date(System.currentTimeMillis());
				if (cliente.getAuto() instanceof Moto) {
					moto = (Moto) cliente.getAuto();
					trabajo = new Trabajo(0, new Date(System.currentTimeMillis()), null, moto, cliente, mecanico);
				}
				else {
					turismo = (Turismo)cliente.getAuto();
					trabajo = new Trabajo(0, new Date(System.currentTimeMillis()), null, turismo, cliente, mecanico);
				}
			}else {
				
				 trabajo = new Trabajo(0, new Date(System.currentTimeMillis()), null, turismo, cliente, null);
			}
			
			
		}
		
		return trabajo;
	}
	
	public void updateVehiculo() {
		
		Persona pBuscada = buscarPersona();
		Persona pNueva = null;
		String idBuscada = null;
		
		if(pBuscada instanceof Cliente) {
			
			for(Entry<String , Persona> p : personas.entrySet()) {
				if(p.getValue().getDni().equals(pBuscada.getDni())) {
					idBuscada = p.getKey();
				}
			}
			pNueva = pBuscada;
			Automovil autoTipo = entradaAutomovil();
			//Uso de constructor copia para poder instanciar otro vehiculo
			// Y no machaque la referencia del anterior
			if (autoTipo instanceof Turismo) {
				pNueva.setAuto(new Turismo((Turismo)autoTipo));
			}else {
				pNueva.setAuto(new Moto((Moto)autoTipo));
			}
			
			
			if(personas.replace(idBuscada, pNueva) != null)
				System.out.println("Modificacion correcta");
			else {
				System.err.println("Error al modificar");
			}
			
		}else {
			System.err.println("Introduzca un Cliente valido");
		}
	
		
		
	}
	
	public void informeVehiculos() {
		System.out.println("Vehiculos en el taller : ");
		for(Entry<String , Trabajo> trabajo : trabajos.entrySet()) {
				if(trabajo.getValue().getFin() == null) {
				System.out.println("\tMarca : " + trabajo.getValue().getAuto().getMarca() + " Matricula : "+
						trabajo.getValue().getAuto().getMatricula());
			}
		}
	}
	
	
	public void updateTrabajo() {
		
		Trabajo tBuscada = buscarTrabajo();
		Trabajo tNueva = null;
		String idBuscada = null;
		
		if(tBuscada instanceof Trabajo) {
			
			for(Entry<String , Trabajo> t : trabajos.entrySet()) {
				if(t.getValue().getCliente().getDni().equals(tBuscada.getCliente().getDni())
						&& t.getValue().getInicio().equals(tBuscada.getInicio())) {
					idBuscada = t.getKey();
				}
			}
			tNueva = (Trabajo) entradaTrabajo();
			System.out.println("Introduzca la ID que quiere cambiar : ");
			
			if(trabajos.replace(idBuscada, tNueva) != null)
				System.out.println("Modificacion correcta");
			else {
				System.err.println("Error al modificar");
			}
			
		}else {
			System.err.println("Introduzca un Trabajo valido");
		}
	
	}

}
