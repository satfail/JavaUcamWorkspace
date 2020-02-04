package edu.ucam.interfacePaciente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import edu.ucam.estructuraclases.Expediente;
import edu.ucam.estructuraclases.Paciente;


public class HospitalImp extends UnicastRemoteObject implements Hospital{
	
	private static final long serialVersionUID = 1L;
	private static HashMap<Integer, Paciente> listaPacientes = new HashMap<Integer, Paciente>();
	private static HashMap<Integer, Expediente> listaExpedientes = new HashMap<Integer, Expediente>();

		
			
	public HospitalImp(HashMap<Integer, Paciente> listaPacientes, HashMap<Integer, Expediente> listaExpedientes)
			throws RemoteException {
		super();
		HospitalImp.listaPacientes = listaPacientes;
		HospitalImp.listaExpedientes = listaExpedientes;
	}
	
	

	public HospitalImp() throws RemoteException {
		super();
	}



	@Override
	public boolean addPaciente(Paciente p) throws RemoteException {
		int index = calculoID(p);
		if (listaPacientes.containsKey(index))
			return false;
		else {
			listaPacientes.put(index, p);
			return true;
			}
	}



	@Override
	public boolean updatePaciente(Paciente p, int index) throws RemoteException {
		
		if (!listaPacientes.containsKey(index))
			return false;
		else {
			listaPacientes.replace(index, p);
			return true;
			}

	}



	@Override
	public void removePaciente(int index) throws RemoteException {
		Paciente p = null;
		p= listaPacientes.remove(index);
		if(p != null) {
			System.out.println("Paciente : " + p.getNombre()+ " Borrado");
		}
		else {
			System.err.println("Error al Borrar " );
		}

	}



	@Override
	public boolean addExpediente(Expediente e) throws RemoteException {
		int index = calculoID(e);
		if (listaExpedientes.containsKey(index))
			return false;
		else {
			listaExpedientes.put(index, e);
			return true;
			}
	}



	@Override
	public boolean updateExpediente(Expediente e, int index) throws RemoteException {
		if (!listaExpedientes.containsKey(index))
			return false;
		else {
			listaExpedientes.replace(index, e);
			return true;
			}
	}



	@Override
	public void removeExpediente(int index) throws RemoteException {
		Expediente e = null;
		e= listaExpedientes.remove(index);
		if(e != null) {
			System.out.println("Expediente : " + e.getObservaciones()+ " Borrado");
		}
		else {
			System.err.println("Error al Borrar " );
		} 
	}



	public Integer calculoID (Object o)
	{
		int contador = 0;
		if( o instanceof Paciente) {
			do {
				contador++;
			}while(listaPacientes.containsKey(contador));
		}
		
		if( o instanceof Expediente) {
			do {
				contador++;
			}while(listaExpedientes.containsKey(contador));
		}
		
		
		return contador;
	}



	@Override
	public HashMap<Integer, Paciente> getListaPacientes() throws RemoteException {
		return listaPacientes;
		
	}



	@Override
	public HashMap<Integer, Expediente> getListaExpedientes() throws RemoteException {
		return listaExpedientes;
		
	}



	@Override
	public void listarPacientes() throws RemoteException {
		for(Map.Entry<Integer, Paciente> p : listaPacientes.entrySet()) {
			System.out.println("ID : " + p.getKey() + " DNI : " + p.getValue().getDni() +
					" Nombre: "+ p.getValue().getNombre());
		}
		
	}



	@Override
	public void listarExpedientes() throws RemoteException {
		for(Map.Entry<Integer, Expediente> ex : listaExpedientes.entrySet()) {
			System.out.println("IDEXPEDIENTE : " + ex.getKey() + " DNI : " + ex.getValue().getP().getDni() +
					" Nombre: "+ ex.getValue().getP().getNombre());
			System.out.println("Observaciones :" + ex.getValue().getObservaciones() + 
					" Tratamiento " + ex.getValue().getTratamiento());
			System.out.println("----------------------------------");
	}

}

}
	
	


