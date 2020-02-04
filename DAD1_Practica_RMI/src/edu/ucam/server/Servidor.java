package edu.ucam.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import edu.ucam.application.Hospital;
import edu.ucam.application.HospitalImp;


public class Servidor {
	
	public static void main(String[] args) {
		try {
			//Lanzamos Registro para crear la lista de registros 
			//con los objetos exportados e interfaz para la busqueda de 
			//estos
			System.out.println("Lanzando el Registro...");
			LocateRegistry.createRegistry(1099); 
			System.out.println("OK");
			
			///Creamos el objeto
			Hospital hospital = new HospitalImp(); /// Interface = a implementacion
			Naming.rebind("rmi://localhost:1099/HospitalCentral", hospital);
			
			
			
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}


}
