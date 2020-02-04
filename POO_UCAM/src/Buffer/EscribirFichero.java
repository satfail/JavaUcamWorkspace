package Buffer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.io.BufferedWriter;

public class EscribirFichero {
	
	private String frase = "Hola Mundo";
	
	public void escribir() {
		
		try {
			
			FileWriter entrada = new FileWriter("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO_UCAM/src/Buffer/Escribe.txt",true);
			BufferedWriter bw = new BufferedWriter(entrada);
			entrada.write(frase);
			
			entrada.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
