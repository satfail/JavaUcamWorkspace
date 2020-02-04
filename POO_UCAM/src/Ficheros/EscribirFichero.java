package Ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
	
	
	
	public void escribir() {
		
		
		String frase="Prueba de escritura";
		
		//USAMOS LA CLASE FILEWRITER 
		
		try {
			
			//FileWriter escritura = new FileWriter("C:/Users/ITIS/Dropbox/Departamento/2018/Asignaturas/POO/Ejemplos Eclipse/prueba/src/Ficheros/ejemploEscribir.txt");
		
			//El A�adir true sirve para escribir en el fichero en el caso de que ya exista:
			
			FileWriter escritura = new FileWriter("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_UCAM/src/Ficheros/ejemploEscribir.txt",true);
			
			
		//en el archivo creado almacene frase 
			for (int i = 0; i < frase.length(); i++) {
				
				escritura.write(frase.charAt(i));
			
			}
			
			
			escritura.close();
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
