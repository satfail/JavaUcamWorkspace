package edu.ucam.application;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
import edu.ucam.pojos.Tratamiento;



public interface Hospital  extends Remote{
	
	public boolean addPaciente(Paciente paciente) throws RemoteException;
	public boolean updatePaciente(Paciente paciente, int index) throws RemoteException;
	public Paciente getPaciente(int index) throws RemoteException;
	public void removePaciente(int index) throws RemoteException;
	public HashMap<Integer, Paciente> getListaPacientes() throws RemoteException;
	public void listarPacientes() throws RemoteException;
	
	public boolean addMedico(Medico medico) throws RemoteException;
	public Medico getMedico(int index) throws RemoteException;
	public boolean updateMedico(Medico medico, int index) throws RemoteException;
	public void removeMedico(int index) throws RemoteException;
	public HashMap<Integer, Medico> getListaMedico() throws RemoteException;
	public void listarMedico() throws RemoteException;

	
	public boolean addExpediente(Expediente expediente) throws RemoteException;
	public Expediente getExpediente(int index) throws RemoteException;
	public boolean updateExpediente(Expediente expediente, int index) throws RemoteException;
	public void  removeExpediente(int index) throws RemoteException;
	public HashMap<Integer, Expediente>  getListaExpedientes() throws RemoteException;
	public void listarExpedientes() throws RemoteException;
	public boolean addPaciente2Exp (Integer idPaciente, Integer idExpediente) throws RemoteException;
	public boolean addMedico2Exp (Integer idMedico, Integer idExpediente) throws RemoteException;
	public boolean addTratam2Exp (Tratamiento tratamiento, Integer idExpediente) throws RemoteException;
	public boolean removePacienteFROMExp ( Integer idExpediente) throws RemoteException;
	public boolean removedMedicoFROMExp ( Integer idExpediente) throws RemoteException;
	public boolean removeTratamFROMExp ( Integer idExpediente) throws RemoteException;
	
	public int count(Object object) throws RemoteException;

}
