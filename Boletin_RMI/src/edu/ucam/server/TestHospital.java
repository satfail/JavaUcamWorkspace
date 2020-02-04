package edu.ucam.server;

import java.rmi.RemoteException;

import edu.ucam.estructuraclases.Expediente;
import edu.ucam.estructuraclases.Paciente;
import edu.ucam.interfacePaciente.Hospital;
import edu.ucam.interfacePaciente.HospitalImp;

public class TestHospital {
	
	
	public static void main(String[] args) {
		Paciente p = new Paciente("Javier", "Garcia", "233323f");
		Expediente ex = new Expediente("Enfermo ", "Zotal en la entrepierna", p);
		try {
			Hospital hospital = new HospitalImp();

			System.out.println(hospital.addExpediente(ex));
			System.out.println(hospital.addExpediente(ex));
			System.out.println(hospital.addExpediente(ex));
			System.out.println(hospital.addPaciente(p));
			System.out.println(hospital.addPaciente(p));
			System.out.println(hospital.addPaciente(p));

			System.out.println(hospital.updatePaciente(p, 2));
			System.out.println(hospital.updateExpediente(ex, 1));
			
			hospital.removePaciente(2);
			hospital.removeExpediente(2);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		
		
		
	}

}
