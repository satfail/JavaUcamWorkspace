package Excepciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Manejandolas {
	
	public  void leerArchivo()  { //IO es para el br
		
		try { //Intenta hacer esto
			File  archivo = new File("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO2/src/Excepciones/prueba");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			while((linea = br.readLine() ) != null ) {
				
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) { //En caso de expcion captura
			JOptionPane.showMessageDialog(null,"No se ha encontrado la ruta del archivo");
		} catch (IOException e) { // Captura el IOException
			
			JOptionPane.showMessageDialog(null,"Error al leer el archivo");
		}
		finally { //Se ejecuta siempre, aunque tengamos excepcion o no , es decir hara el try y el finally o el catch y el finally
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
			Manejandolas pruebaManejandolas = new Manejandolas();
			pruebaManejandolas.leerArchivo();// Como no he puesto el metodo static, tengo que instanciar
		
	}

}
