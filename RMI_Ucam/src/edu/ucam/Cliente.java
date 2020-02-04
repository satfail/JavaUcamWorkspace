package edu.ucam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {

	public static void main(String[] args) {
		try {
			Calculadora calculadora = (Calculadora)Naming.lookup("rmi://localhost:1099/CalculadoraUCAM");
			
			System.out.println(calculadora.add(4, 3));
			System.out.println(calculadora.rest(4, 3));
			System.out.println(calculadora.mul(4, 3));
			
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
