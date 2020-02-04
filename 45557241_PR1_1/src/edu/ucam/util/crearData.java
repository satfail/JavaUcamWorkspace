package edu.ucam.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import edu.ucam.aplicacion.Automovil;
import edu.ucam.aplicacion.Cliente;
import edu.ucam.aplicacion.Comercial;
import edu.ucam.aplicacion.Jefe;
import edu.ucam.aplicacion.Mecanico;
import edu.ucam.aplicacion.Moto;
import edu.ucam.aplicacion.Persona;
import edu.ucam.aplicacion.Trabajo;
import edu.ucam.aplicacion.Turismo;

public class crearData {

	HashMap<String, Automovil> autos = new HashMap<String, Automovil>();
	TreeMap<String, Persona> personas = new TreeMap<String, Persona>();
	public static void main(String[] args) throws IOException {
		HashMap<String, Automovil> autos = new HashMap<String, Automovil>();
		TreeMap<String, Persona> personas = new TreeMap<String, Persona>();
		String fileAuto = "data/autos.data";
		String filePersona= "data/persona.data";

		try {
			crearDatosPersona(filePersona, personas);
			crearDatosAuto(fileAuto, autos,personas);
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static  void crearDatosPersona(String filePersona, TreeMap<String, Persona> personas) throws ClassNotFoundException {
	
	try {
		
        FileOutputStream file = new FileOutputStream 
                (filePersona); 
        ObjectOutputStream out = new ObjectOutputStream 
                (file); 
        
        Persona p1 = new Mecanico("Juan", "Perez", "2342423L", null, 1203.45f, 34, false);
        Persona p2 = new Mecanico("Pedro", "Lorenzo", "123323V", null, 1303.43f, 46, false);
        Persona p3 = new Cliente("Maria", "Barroso", "4242423F", new Moto("242424H", 45, "Vespino", "Vespino"), "C1", new Date(2019, 1, 1));
        Persona p4 = new Cliente("Rocio", "Vergara", "78875F", new Turismo("4234RFG", 95, "Renault", "Megane"), "C2", new Date(2018, 2, 2));
        Persona p5 = new Jefe("Lucas", "Gragera", "4232323V", null, 5789.45f, 90);
        Persona p6 = new Comercial("Carmen", "Gragera", "93992L", null);
        Persona p7= new Cliente("Jesus", "Gomez", "432323F", new Turismo("1242H", 390, "Ferrari", "489"), "C3", new Date(2019, 12, 10));
        Persona p8 = new Cliente("Lucia", "Hernandez", "2178875F", new Turismo("8934RFG", 290, "Porsche", "Carrera"), "C4", new Date(2018, 1, 2));
        
        personas.put("M1", p1);
        personas.put("M2", p2);
        personas.put("C1", p3);
        personas.put("C2", p4);
        personas.put("J", p5);
        personas.put("V1", p6);
        personas.put(((Cliente)p7).getIdCliente(), p7);
        personas.put(((Cliente)p8).getIdCliente(), p8);
        

     
        out.writeObject(personas);
        out.close(); 
        file.close(); 
        
        
        personas = null;
        
        FileInputStream file2 = new FileInputStream 
                (filePersona); 
        ObjectInputStream in = new ObjectInputStream 
                (file2); 
        personas = (TreeMap<String, Persona>)in.readObject();
        file2.close();
        in.close();
        for(Entry<String, Persona> p: personas.entrySet()) {
        	if(p.getValue() instanceof Cliente )
        		System.out.println((Cliente)p.getValue());
        }

		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}

public static  void crearDatosAuto(String fileAuto, HashMap<String, Automovil> autos,	TreeMap<String, Persona> personas) throws ClassNotFoundException {
	
	try {
		
        FileOutputStream file = new FileOutputStream 
                (fileAuto); 
        ObjectOutputStream out = new ObjectOutputStream 
                (file); 
        
        Moto a1 = (Moto) personas.get("C1").getAuto();
        a1.setCilindrada(600);a1.setCaballos(140);
        Turismo a2=  (Turismo)personas.get("C2").getAuto();
        a2.setCapacidad(30);a2.setnPuertas(4);
        Turismo a3=  (Turismo)personas.get("C3").getAuto();
        a3.setCapacidad(15);a3.setnPuertas(2);
        Turismo a4=  (Turismo)personas.get("C4").getAuto();
        a4.setCapacidad(15);a4.setnPuertas(2);

        
        autos.put("AM1", a1);
        autos.put("AT1", a2);
        autos.put("AT2", a3);
        autos.put("AT3", a4);
     
        out.writeObject(autos);
        out.close(); 
        file.close(); 
        
        
        autos = null;
        
        FileInputStream file2 = new FileInputStream 
                (fileAuto); 
        ObjectInputStream in = new ObjectInputStream 
                (file2); 
        autos = (HashMap<String, Automovil>)in.readObject();
        file2.close();
        in.close();
        for(Entry<String, Automovil> a: autos.entrySet()) {
        	if(a.getValue() instanceof Moto )
        		System.out.println((Moto)a.getValue());
        }
        
        for(Entry<String, Automovil> a: autos.entrySet()) {
        	if(a.getValue() instanceof Turismo )
        		System.out.println((Turismo)a.getValue());
        }

		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}

}
