package edu.ucam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {	
		
		try {
			//Lanzar un registro
			System.out.print("Lanzamos registro... ");
			LocateRegistry.createRegistry(1099);		
			System.out.println("[Ok]");
			
			//Crear el objeto
			Calculadora calculadora = new CalculadoraImpl();
			System.out.println("Probando calculadora... " + calculadora.add(4, 7));
			
			//Registrar el objeto
			Naming.rebind("rmi://localhost:1099/CalculadoraUCAM", calculadora);
			
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}		
	}
}
