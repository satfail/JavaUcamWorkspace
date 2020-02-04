package edu.ucam;


public interface Calculadora extends java.rmi.Remote{
	
	public long add(long a, long b) throws java.rmi.RemoteException;
	public long rest(long a, long b) throws java.rmi.RemoteException;
	public long mul(long a, long b) throws java.rmi.RemoteException;
	public long div(long a, long b) throws java.rmi.RemoteException;

}
