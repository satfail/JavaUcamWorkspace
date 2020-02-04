package edu.ucam;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CalculadoraImpl() throws RemoteException {
		super();
	}

	@Override
	public long add(long a, long b) throws RemoteException {
		System.out.println("\tEjecutada suma en servidor");
		return a + b;
	}

	@Override
	public long rest(long a, long b) throws RemoteException {
		System.out.println("\tEjecutada resta en servidor");
		return a - b;
	}

	@Override
	public long mul(long a, long b) throws RemoteException {
		System.out.println("\tEjecutada multiplicación en servidor");
		return a * b;
	}

	@Override
	public long div(long a, long b) throws RemoteException {
		System.out.println("\tEjecutada division en servidor");
		return a / b;
	}

}
