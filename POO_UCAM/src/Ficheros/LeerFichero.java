package Ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	
	public void lee() {
		
				
		try {
			
			
			FileReader entrada = new FileReader("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_UCAM/src/Ficheros/ejemploLeer");
			int c= 0; //para que lea el primer caracter del fichero
			
			
			while (c!=-1) { //mientras no llegues al final de los datos del fichero
				
				//c=entrada.read();
				//System.out.println(c);// obtenemos los unicodes del texto del fichero
				
								
				c=entrada.read();
				char letra = (char)c; //hacemos un casting de char de lo devuelve el m�todo y poder entenderlo
				System.out.print(letra);

			}
			entrada.close(); //No debemos olvidar cerrar el flujo de datos
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se ha encontrado el archivo");
		}
	}
	

}
