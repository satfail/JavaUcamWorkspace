package edu.ucam.interfacePaciente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import edu.ucam.estructuraclases.Expediente;
import edu.ucam.estructuraclases.Paciente;

public interface Hospital extends Remote {
	
	public boolean addPaciente(Paciente p) throws RemoteException;
	public boolean updatePaciente(Paciente p, int index) throws RemoteException;
	public void removePaciente(int index) throws RemoteException;
	public HashMap<Integer, Paciente> getListaPacientes() throws RemoteException;
	public void listarPacientes() throws RemoteException;
	
	
	public boolean addExpediente(Expediente e) throws RemoteException;
	public boolean updateExpediente(Expediente e, int index) throws RemoteException;
	public void  removeExpediente(int index) throws RemoteException;
	public HashMap<Integer, Expediente>  getListaExpedientes() throws RemoteException;
	public void listarExpedientes() throws RemoteException;

	
	

}
