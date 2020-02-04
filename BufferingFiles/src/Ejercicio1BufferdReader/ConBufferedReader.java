package Ejercicio1BufferdReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConBufferedReader {
	public static void main(String[] args) throws FileNotFoundException {
		LeerConBuffered leo = new LeerConBuffered();
		leo.leer();
	}
}

class LeerConBuffered  {

	public void leer() throws FileNotFoundException {
		FileReader entrada = new FileReader("archivo.txt");
		///Mete el archivo en un buffer del que luego se lee(lugar intermedio)
		BufferedReader br = new BufferedReader(entrada);
		String linea = "";
		while(linea != null)
			try {
				if(linea!=null) 
					System.out.println(linea);
				
				linea=br.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
