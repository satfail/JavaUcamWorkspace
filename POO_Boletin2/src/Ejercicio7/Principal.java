package Ejercicio7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class Principal {
	
	public static void main(String[] args) {
		String filename = "/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_Boletin2/src/Ejercicio7/datacoche.dat";
        HashMap<String, Coche> cochesByMatricula = new HashMap<String, Coche>();
		File archivo = new File(filename);
		
		
		if(!archivo.exists()) {
				
			Coche c1 = new Coche("Sedane", "Audi", "Blanco", 1000);
			Coche c2 = new Coche(c1);
			Coche c3 = new Coche("Jeep", "Jeep", "Verde", 541000);
			
			
	        
	        try {
				
	            FileOutputStream file = new FileOutputStream 
	                    (archivo); 
	            ObjectOutputStream out = new ObjectOutputStream 
	                    (file); 
	            out.writeObject(c1);
	            out.writeObject(c2);
	            out.writeObject(c3);
	            out.writeObject(null);
	            out.close(); 
	            file.close(); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		else {
			 try {
			           FileInputStream file = new FileInputStream 
			                   (filename); 
			           ObjectInputStream in = new ObjectInputStream 
			                   (file); 
		
			           		cochesByMatricula.put("2343WDA", (Coche)in.readObject());
			           		cochesByMatricula.put("3453JKL", (Coche)in.readObject());
			           		cochesByMatricula.put("3124OKM", (Coche)in.readObject());
		
			}catch (Exception e) {
				e.printStackTrace();
			}
			       
			       for (Entry<String, Coche> c : cochesByMatricula.entrySet()) {
			    	    String key = c.getKey();
			    	    Object value = c.getValue();
			    	    System.out.println("Matricula " + c.getKey() + " Marca " + c.getValue().getMarca());
			    	}   
			    	   
			       
			}
		}
}