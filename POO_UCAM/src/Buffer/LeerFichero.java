package Buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	
	public void lee() {
		
				
		try {
	
			
			FileReader entrada = new FileReader("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_UCAM/src/Buffer/LeerBuffer");
			
			//Creamos el buffer y almacenamos en la memoria de el fichero
			
			BufferedReader miBuffer= new BufferedReader(entrada);
			
			String linea="";
		
			while (linea!=null) { //leer l�nea a l�nea mientras no llegues al final  del fichero
				
			   linea=miBuffer.readLine();
			
				if (linea !=null) {
					   System.out.print(linea);
					
				}
			

			}
			entrada.close(); //No debemos olvidar cerrar el flujo de datos
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se ha encontrado el archivo");
		}
	}
	

}
