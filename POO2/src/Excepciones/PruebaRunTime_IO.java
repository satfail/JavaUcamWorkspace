package Excepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// IOException 
								//--> Exception
//RunTimeException
						
																				// --> Throwable
		
								//    	Error
// IO son excepciones verificadas, java pide que sean tratadas, por ejemplo abrir un archivo y no encontrar ruta
//Abrir Socket y no conectar...

//Las RunTime son excepciones no Verificadas, errores que comete el programador en su programa en ejecucion
// como por ejemplo dividir por cero, o no verificar las entradas y salidas de datos

//La subclase error hacer referencia a errores en la maquina, falta de espacio en memoria...
//Throwable es la superclase de las que beben las excepciones, hereda de la clase Object

import java.util.Scanner;

public class PruebaRunTime_IO {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{ //No me pide el try y catch porque he puesto que 
																																				 // va a tirar excepciones el main
		//Verificada
		String linea;
		//Si pongo ruta erronea sale excepcion
		BufferedReader br = new BufferedReader(new FileReader("/Users/satfail/Onedrive/GSI/3º/eclipse-workspace/POO2/src/Excepciones/prueba"));
		while((linea =br.readLine()) != null) {
			
			System.out.println(linea);
		}
		
		//No verificada, no obliga a meter try y catch
		//Hay que solucionarlo a mano, pero se puede hacer tb con try y catch
		int x =1 ;
		int y =0;
		int num = x/y;
		System.err.println(num);
		
	}

	
}
