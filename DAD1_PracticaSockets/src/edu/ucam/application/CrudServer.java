package edu.ucam.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
import edu.ucam.pojos.Tratamiento;

/**
 * 
 * @author Miguel Angel Gragera García
 * Clase con métodos estáticos para simular una base de datos
 *
 */
public class CrudServer {
	
	private static HashMap<String, Medico> listaMedicos = new HashMap<String, Medico>();
	private static HashMap<String, Paciente> listaPaciente = new HashMap<String, Paciente>();
	private static ArrayList< Tratamiento> listaTratamiento = new ArrayList<Tratamiento>();
	private static HashMap<String, Expediente> listaExpediente = new HashMap<String, Expediente>();
	private static String fileMedico = "serializables/medico.data";
	private static String filePaciente = "serializables/paciente.data";
	private static String fileTratamiento = "serializables/tratamiento.data";
	private static String fileExpediente = "serializables/expediente.data";


	public static HashMap<String, Medico> getListaMedicos() {
		return listaMedicos;
	}
	public static HashMap<String, Paciente> getListaPaciente() {
		return listaPaciente;
	}
	public static ArrayList<Tratamiento> getListaTratamiento() {
		return listaTratamiento;
	}
	public static HashMap<String, Expediente> getListaExpediente() {
		return listaExpediente;
	}
	
	
	/// Create, Read , Update, Delete
	
	public static boolean addMedico (Medico m) {		
		String id = calculoID(m);
		if (listaMedicos.containsKey(id))
			return false;
		else {
			listaMedicos.put(id, m);
			return true;
			}
	}
	
	public static boolean addPaciente (Paciente p) {		
		String id = calculoID(p);
		if (listaPaciente.containsKey(id))
			return false;
		else {
			listaPaciente.put(id, p);
			return true;
			}
	}
	
	public static boolean addTratamiento (Tratamiento t) {		
		return listaTratamiento.add(t);
	}
	
	public static boolean addExpediente (Expediente e ) {		
		String id = calculoID(e);
		
		if (listaExpediente.containsKey(id))
			return false;
		else {
			listaExpediente.put(id, e);
			return true;
			}
	}


	public static boolean updateMedico ( Medico m, String idCambio) {		
		if (!listaMedicos.containsKey(idCambio) || !m.getId().equals(idCambio))
			return false;
		else {
			listaMedicos.replace(idCambio, m);
			return true;
			}
	}	
	
	public static boolean updatePaciente ( Paciente p, String idCambio) {		

		if (!listaPaciente.containsKey(idCambio) || !p.getId().equals(idCambio))
			return false;
		else {
			listaPaciente.replace(idCambio, p);
			return true;
			}
	}	
	
	
	public static void informeMedicos() {
		
		for(Entry<String, Medico> m : listaMedicos.entrySet()) {
			System.out.println( m.getValue().getId()+"//" +m.getValue().getNombre());
		}
	}
	public static void informePacientes() {	
		for(Entry<String, Paciente> p : listaPaciente.entrySet()) {
			System.out.println( p.getKey() + "//" +p.getValue().getNombre());
		}
	}	
	
	
	///Leer Datos de Archivo
	
	 public static void leerDatos() {
		 try {
				
	            FileInputStream file = new FileInputStream (fileMedico); 
	            ObjectInputStream in = new ObjectInputStream (file); 
	            listaMedicos = (HashMap<String, Medico>)in.readObject();
	            
	           
	            file = new FileInputStream (filePaciente); 
	            in =new ObjectInputStream  (file); 
	            listaPaciente = (HashMap<String, Paciente>)in.readObject();
	           
	            
	            file = new FileInputStream (fileTratamiento); 
	            in =new ObjectInputStream  (file); 
	            listaTratamiento = (ArrayList<Tratamiento>)in.readObject();
	           

	            
	            
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		 
	 }
	 
		public static boolean addPacExp(String id, String id2) {

			if(CrudServer.getListaPaciente().get(id) != null || CrudServer.getListaExpediente().get(id2) != null ) {
				CrudServer.getListaExpediente().get(id2).setPaciente(CrudServer.getListaPaciente().get(id));
				return true;
			}
			else
				return false;
		}
		
		public static boolean addMedExp(String id, String id2) {
			
			if(CrudServer.getListaMedicos().get(id) != null || CrudServer.getListaExpediente().get(id2) != null ) {
				CrudServer.getListaExpediente().get(id2).setMedico(CrudServer.getListaMedicos().get(id));
				return true;
			}
			else
				return false;
		}

		public static boolean addTrataExp(String id, String id2) {
			Tratamiento tratamiento = CrudServer.getListaTratamiento().get(Integer.parseInt(id));	
			if(tratamiento != null) {
				CrudServer.getListaExpediente().get(id2).getTramientos().add(tratamiento);
				return true;
			}
			else
				return false;
		}
		
		public static boolean removePacExp(String id, String id2) {

			if(CrudServer.getListaPaciente().get(id) != null || CrudServer.getListaExpediente().get(id2) != null ) {
				CrudServer.getListaExpediente().get(id2).setPaciente(null);
				return true;
			}
			else
				return false;
		}
		
		public static boolean removeMedExp(String id, String id2) {

			if(CrudServer.getListaMedicos().get(id) != null || CrudServer.getListaExpediente().get(id2) != null ) {
				try {
				CrudServer.getListaExpediente().get(id2).setMedico(null);
				return true;
				}catch (Exception e) {
					return false;
				}
			}
			else
				return false;
		}

		public static boolean removeTratExp(String id, String id2) {

			if(CrudServer.getListaTratamiento().get(Integer.parseInt(id)) != null || CrudServer.getListaExpediente().get(id2) != null ) {
				CrudServer.getListaExpediente().get(id2).getTramientos().set(Integer.parseInt(id), null);
				return true;
			}
			else
				return false;
		}
	 

		public static String calculoID (Object o)
		{

			int contador = 0;
			String idCalc = null;
			if( o instanceof Paciente) {
				do {
					contador++;
					idCalc =Integer.toString(contador);
					System.out.println(CrudServer.getListaPaciente().size());
				}while(CrudServer.getListaPaciente().containsKey(idCalc));
			}
			
			if( o instanceof Medico) {
				do {
					contador++;
					idCalc = Integer.toString(contador);;
				}while(CrudServer.getListaMedicos().containsKey(idCalc));
			}
			
			if( o instanceof Expediente) {
				do {
					contador++;
					idCalc = Integer.toString(contador);;
				}while(CrudServer.getListaExpediente().containsKey(idCalc));
			}
			
			return idCalc;
		}

	

}

