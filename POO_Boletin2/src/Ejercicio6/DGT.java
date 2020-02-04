package Ejercicio6;

import java.util.ArrayList;
import java.util.Scanner;

public class DGT {
	
	public static void main(String[] args) {
		ArrayList<CarnetDeConducir> listaCarnets = new ArrayList<CarnetDeConducir>();
		Scanner entrada = new Scanner(System.in);
		insertarDatos(listaCarnets);
		darPuntos(listaCarnets);
		ordenar(listaCarnets);
		mostrarDatos(listaCarnets);
	}
	
	
	
	public static void insertarDatos(ArrayList<CarnetDeConducir> lista){
	
	lista.add(new CarnetDeConducir());	
	lista.add(new CarnetDeConducir());	
	
	boolean flag = true;
	String respuesta = null;
	while(flag) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduzca el nombre de la persona : ");
		lista.add(new CarnetDeConducir(entrada.next()));
		System.out.println("Desea Introducir otro carnet? y/n");
		respuesta = entrada.next();
		if (respuesta.equals("n"))
			flag = false;
	}
		
		
	}
	public static void darPuntos(ArrayList<CarnetDeConducir> lista){
		
		for (CarnetDeConducir c : lista) {
			if(c.mesesSinInfracciones() >= 24)
				c.darUnPunto();
		
	}
	}
	public static void mostrarDatos(ArrayList<CarnetDeConducir> lista){	
	
		for( CarnetDeConducir c : lista) {
			System.out.println(c.getNombre() + " Puntos : " +  c.getPuntos());
		}
		
	}
	
	public static void ordenar (ArrayList<CarnetDeConducir> lista) {
		
		boolean flag = false;
		CarnetDeConducir c = null;
		for (int i = 0 ; i< lista.size()-1; i++) {
			if(lista.get(i).compareTo(lista.get(i+1)) < 0)
				c = lista.get(i);
		}
		System.out.println("El que tiene menos puntos es " + c.getNombre() + " Puntos " + c.getPuntos());
	}

}
