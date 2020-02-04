package pooExamen;

import java.util.ArrayList;
import java.util.Scanner;

public class Casa {
	private ArrayList<Sensor> sensores= new ArrayList<Sensor>();
	private static Casa instanciaCasa = null;
	
	private Casa() {}
	
	public static Casa getInstanciaCasa() {
		if(instanciaCasa == null)
			instanciaCasa = new Casa();
			
		return instanciaCasa;

	}
	public ArrayList<Sensor> getSensor() {
		return sensores;
	}

	public void setSensor(ArrayList<Sensor> sensor) {
		this.sensores = sensor;
	}
	public void buscarSensor(int id) {
		for(Sensor s: sensores) {
			if(s.getId() == id)
				System.out.println(s.toString());
		}
	}
	
	public void listarSensores() {
		for(Sensor s: sensores) {
			System.out.println(s.toString());
		}
		
	}
	
}
