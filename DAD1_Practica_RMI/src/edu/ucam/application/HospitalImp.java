package edu.ucam.application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;


import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
import edu.ucam.pojos.Tratamiento;

public class HospitalImp extends UnicastRemoteObject implements Hospital{

	private static final long serialVersionUID = 1L;

	private static HashMap<Integer, Paciente> listaPacientes = new HashMap<Integer, Paciente>();
	private static HashMap<Integer, Expediente> listaExpedientes = new HashMap<Integer, Expediente>();
	private static HashMap<Integer, Medico> listaMedico = new HashMap<Integer, Medico>();
	
	public HospitalImp(HashMap<Integer, Paciente> listaPacientes, HashMap<Integer, Expediente> listaExpedientes,
			HashMap<Integer, Medico> listaMedico)
			throws RemoteException {
		super();
		HospitalImp.listaPacientes = listaPacientes;
		HospitalImp.listaExpedientes = listaExpedientes;
		HospitalImp.listaMedico = listaMedico;
	}
	

	public HospitalImp() throws RemoteException {
		super();
	}

	public boolean addPaciente(Paciente paciente) throws RemoteException {
		int index = calculoID(paciente);
		if (listaPacientes.containsKey(index))
			return false;
		else {
			listaPacientes.put(index, paciente);
			return true;
			}
	}

	
	@Override
	public boolean updatePaciente(Paciente paciente, int index) throws RemoteException {
		if (!listaPacientes.containsKey(index))
			return false;
		else {
			listaPacientes.replace(index, paciente);
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
	public HashMap<Integer, Paciente> getListaPacientes() throws RemoteException {
		return listaPacientes;
	}

	@Override
	public void listarPacientes() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addExpediente(Expediente expediente) throws RemoteException {
		int index = calculoID(expediente);
		if (listaExpedientes.containsKey(index))
			return false;
		else {
			listaExpedientes.put(index, expediente);
			return true;
			}
	}

	@Override
	public boolean updateExpediente(Expediente expediente, int index) throws RemoteException {
		
		if (!listaExpedientes.containsKey(index))
			return false;
		else {
			listaExpedientes.replace(index, expediente);
			return true;
			}
	}

	@Override
	public void removeExpediente(int index) throws RemoteException {
		Expediente expediente= null;
		expediente= listaExpedientes.remove(index);
		if(expediente != null) {
			System.out.println("Expediente : " + expediente.getObservaciones()+ " Borrado");
		}
		else {
			System.err.println("Error al Borrar " );
		} 
		
	}

	@Override
	public HashMap<Integer, Expediente> getListaExpedientes() throws RemoteException {
		return listaExpedientes;
	}

	@Override
	public void listarExpedientes() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addPaciente2Exp(Integer idPaciente, Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null && listaPacientes.get(idPaciente) != null) {
			listaExpedientes.get(idExpediente).setPaciente(listaPacientes.get(idPaciente));
			return true;
		}
		else	
			return false;
	}

	@Override
	public boolean addMedico2Exp(Integer idMedico, Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null && listaMedico.get(idMedico) != null) {
			listaExpedientes.get(idExpediente).setMedico(listaMedico.get(idMedico));
			return true;
		}
		else	
			return false;
	}

	@Override
	public boolean addTratam2Exp(Tratamiento tratamiento, Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null) {
			listaExpedientes.get(idExpediente).setTramientos(new ArrayList<Tratamiento>());
			listaExpedientes.get(idExpediente).getTramientos().add(tratamiento);
			return true;
		}
		else	
			return false;
	}

	@Override
	public boolean removePacienteFROMExp(Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null ) {
			listaExpedientes.get(idExpediente).setPaciente(null);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean removedMedicoFROMExp(Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null ) {
			listaExpedientes.get(idExpediente).setMedico(null);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean removeTratamFROMExp( Integer idExpediente) throws RemoteException {
		if(listaExpedientes.get(idExpediente) != null ) {
			listaExpedientes.get(idExpediente).setTramientos(null);
			return true;
		}
		else
			return false;
	}

	@Override
	public int count(Object object) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
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
		if( o instanceof Medico) {
			do {
				contador++;
			}while(listaMedico.containsKey(contador));
		}
		
		return contador;
	}


	@Override
	public boolean addMedico(Medico medico) throws RemoteException {
		Integer id = calculoID(medico);
		if (listaMedico.containsKey(id))
			return false;
		else {
			listaMedico.put(id, medico);
			return true;
			}
	}


	@Override
	public boolean updateMedico(Medico medico, int index) throws RemoteException {
		if (!listaMedico.containsKey(index))
			return false;
		else {
			listaMedico.replace(index, medico);
			return true;
			}
	}


	@Override
	public void removeMedico(int index) throws RemoteException {
		Medico medico= null;
		medico= listaMedico.remove(index);
		if(medico != null) {
			System.out.println("Medico : " + medico.getNombre()+ " Borrado");
		}
		else {
			System.err.println("Error al Borrar " );
		} 
		
	}


	@Override
	public HashMap<Integer, Medico> getListaMedico() throws RemoteException {

		return listaMedico;
	}


	@Override
	public void listarMedico() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Paciente getPaciente(int index) throws RemoteException {
		Paciente paciente = null;
		paciente= listaPacientes.get(index);
		return paciente;
	}


	@Override
	public Medico getMedico(int index) throws RemoteException {
		Medico medico = null;
		medico = listaMedico.get(index);
		return medico;
	}


	@Override
	public Expediente getExpediente(int index) throws RemoteException {
		Expediente expediente = null;
		expediente = listaExpedientes.get(index);
		return expediente;
	}

}
