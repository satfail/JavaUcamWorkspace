package edu.ucam.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
import edu.ucam.pojos.Tratamiento;
/**
 * 
 * @author Miguel Angel Gragera Garcia
 * Clase creada para insertar datos en la práctica.
 */

public class DatosPractica {
	private static HashMap<String, Expediente> listaExpediente = new HashMap<String, Expediente>();
	private static HashMap<String, Medico> listaMedicos = new HashMap<String, Medico>();
	private static HashMap<String, Paciente> listaPaciente = new HashMap<String, Paciente>();
	private static ArrayList<Tratamiento> listaTratamiento = new ArrayList<Tratamiento>();
	public static void main(String[] args) {
		
		String fileMedico = "serializables/medico.data";
		String filePaciente = "serializables/paciente.data";
		String fileTratamiento = "serializables/tratamiento.data";
		String fileExpediente = "serializables/expediente.data";
		try {
			crearDatosMedico(fileMedico);
			crearDatosPaciente(filePaciente);
			crearDatosTratamiento(fileTratamiento);
			crearDatosExpediente(fileExpediente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static  void crearDatosMedico(String fileMedico) throws ClassNotFoundException {
		
		try {
			
            FileOutputStream file = new FileOutputStream 
                    (fileMedico); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            
            Medico m1 = new Medico("1", "Carlos", "Perez", "General");
            Medico m2 = new Medico("2", "Pedro", "Hernandez", "Cirugia");
            Medico m3 = new Medico("3", "Lucas", "Gragera", "Laboratorio");
            Medico m4 = new Medico("4", "Carmen", "Gragera", "General");
            
            listaMedicos.put(m1.getId(), m1);
            listaMedicos.put(m2.getId(), m2);
            listaMedicos.put(m3.getId(), m3);
            listaMedicos.put(m4.getId(), m4);
         
            out.writeObject(listaMedicos);
            out.close(); 
            file.close(); 
            
            
            listaMedicos = null;
            
            FileInputStream file2 = new FileInputStream 
                    (fileMedico); 
            ObjectInputStream in = new ObjectInputStream 
                    (file2); 
            listaMedicos = (HashMap<String, Medico>)in.readObject();
            
            for(Entry<String, Medico> m: listaMedicos.entrySet()) {
            	System.out.println(m.getValue().getNombre());
            }
  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static  void crearDatosPaciente(String filePaciente) throws ClassNotFoundException {
		

		try {
			
            FileOutputStream file = new FileOutputStream 
                    (filePaciente); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            
            Paciente p1 = new Paciente("1", "Miguel", "Gragera", new Date(1986, 5, 1));
            Paciente p2 = new Paciente("2", "Maria", "Barroso", new Date(1985, 3, 9));
            Paciente p3 = new Paciente("3", "Juan", "Hermoso", new Date(1996, 12, 10));
            Paciente p4 = new Paciente("4", "Victor", "Bueno", new Date(1973, 8, 21));
            
            listaPaciente.put(p1.getId(), p1);
            listaPaciente.put(p2.getId(), p2);
            listaPaciente.put(p3.getId(), p3);
            listaPaciente.put(p4.getId(), p4);
         
            out.writeObject(listaPaciente);
            out.close(); 
            file.close(); 
            
            
            listaPaciente = null;
            
            FileInputStream file2 = new FileInputStream 
                    (filePaciente); 
            ObjectInputStream in = new ObjectInputStream 
                    (file2); 
            listaPaciente = (HashMap<String, Paciente>)in.readObject();
            
            for(Entry<String, Paciente> p: listaPaciente.entrySet()) {
            	System.out.println(p.getValue().getNombre());
            }
  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

public static  void crearDatosTratamiento(String fileTratamiento) throws ClassNotFoundException {
		

		try {
			
            FileOutputStream file = new FileOutputStream 
                    (fileTratamiento); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            
            Tratamiento t1 = new Tratamiento("1", "Reposo");
            Tratamiento t2 = new Tratamiento("2", "Paracetamol");
            Tratamiento t3 = new Tratamiento("3", "Cirugia");
            Tratamiento t4 = new Tratamiento("4", "2 meses de vida");
            listaTratamiento.add( t1);
            listaTratamiento.add( t2);
            listaTratamiento.add( t3);
            listaTratamiento.add(t4);
         
            out.writeObject(listaTratamiento);
            out.close(); 
            file.close(); 
            
            
            listaTratamiento = null;
            
            FileInputStream file2 = new FileInputStream 
                    (fileTratamiento); 
            ObjectInputStream in = new ObjectInputStream 
                    (file2); 
            listaTratamiento = (ArrayList<Tratamiento>)in.readObject();
            
            for(Tratamiento t: listaTratamiento) {
            	System.out.println(t.getId());
            }
  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
	}

public static  void crearDatosExpediente(String fileExpediente) throws ClassNotFoundException {
	

	try {
		
        FileOutputStream file = new FileOutputStream 
                (fileExpediente); 
        ObjectOutputStream out = new ObjectOutputStream 
                (file); 
        

   
       Expediente ex1 = new Expediente(listaPaciente.get("1"), listaMedicos.get("2"), null);
       Expediente ex2 = new Expediente(listaPaciente.get("2"), listaMedicos.get("1"), null);
       Expediente ex3 = new Expediente(listaPaciente.get("3"), listaMedicos.get("4"), null);
       Expediente ex4 = new Expediente(listaPaciente.get("4"), listaMedicos.get("3"), null);
       
        
        listaExpediente.put("1", ex1);
        listaExpediente.put("2", ex2);
        listaExpediente.put("3", ex3);
        listaExpediente.put("4", ex4);
     
        out.writeObject(listaExpediente);
        out.close(); 
        file.close(); 
        
        
        listaExpediente = null;
        
        FileInputStream file2 = new FileInputStream 
                (fileExpediente); 
        ObjectInputStream in = new ObjectInputStream 
                (file2); 
        listaExpediente = (HashMap<String, Expediente>)in.readObject();
        
        for(Entry<String, Expediente> t: listaExpediente.entrySet()) {
        	System.out.println(t.getKey() + " " +t.getValue().getPaciente().getNombre());
        }

		
	} catch (IOException e) {
		e.printStackTrace();
	}
	

	
	
}


}
