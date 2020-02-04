package miSerializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Principal {
	
	
	public static void main(String[] args) {
		
		Persona [] personas = new Persona [3];
		
		personas[0] = new Persona("Lucas", 3, "0000");
		personas[1] = new Empleado("Maria Jose", 34, "4342424242", "CEO", 3465.70f);
		personas[2] = new Persona("Carmen", 0, "00001");
		
		String filename = "/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_UCAM/src/miSerializable/dataempleado.dat";
		try {
			
            FileOutputStream file = new FileOutputStream 
                    (filename); 
            ObjectOutputStream out = new ObjectOutputStream 
                    (file); 
            
            for(int i = 0; i < personas.length; i++) {
            	
            	out.writeObject(personas[i]);
            	
            }
            
            out.close(); 
            file.close(); 
            
  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Sacando datos
		
       for(int i = 0; i < personas.length; i++) {
        	
        	personas[i] = null;
        }
       
       try {
           FileInputStream file = new FileInputStream 
                   (filename); 
           ObjectInputStream in = new ObjectInputStream 
                   (file); 
           
           for(int i = 0; i < personas.length; i++) {
           		if(personas[i] instanceof Empleado)
           			personas[i] = (Empleado)in.readObject(); 
           		else {
           			personas[i] = (Persona)in.readObject(); 
				}
        	   
           }
           
           in.close(); 
           file.close();
           
           for(Persona p : personas) {
              	
        	   if(p instanceof Empleado)
        		   ((Empleado)p).printdata(((Empleado)p));
        	   else
        		   p.printdata(p);
        	   
           }
           
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        
        
        
		
		
	}

}
