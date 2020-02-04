package edu.ucam.root;



import edu.ucam.application.CrudServer;
import edu.ucam.application.Servidor;


public class RootServer {
	
	public static void main(String[] args) {		
		CrudServer.leerDatos(); //Leemos los datos creados para la práctica
		Servidor servidor = new Servidor();
		servidor.lanzarServidor();
	 
	}
	
}