
package edu.ucam.application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;
/** @author Miguel Angel Gragera Garcia
 * Hilo de Datos, su constructor recibe el comando, id necesaria para las operaciones
 *  y el puerto de conexion
 */


public class HiloDatos extends Thread{
	
	private String comando;
	private  String id;
	private  String id2;
	private int puerto;
	/**
	 * 
	 * @param comando
	 * @param id
	 * @param puerto
	 * @param id2
	 */
	public HiloDatos(String comando, String id, int puerto,String id2) {
		super();
		this.comando = comando;
		this.id = id;
		this.puerto = puerto;
		this.id2 = id2;
	}
	
	public HiloDatos(String comando, String id, int puerto) {
		super();
		this.comando = comando;
		this.id = id;
		this.puerto = puerto;
		this.id2 = null;
	}
	public String getComando() {
		return comando;
	}
	
	/**
	 * Metodo run donde se ejecuntan las acciones del hilo 
	 */
	public void run() {

		
		System.out.println(" Hilo datos : " + comando);
		
		ServerSocket socketDatosServidor;
		Socket socketDatos;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		PrintWriter pw;
		String lineaEnvia = null;
		boolean flag = false;
		Paciente paciente;
		Expediente expediente;
		Medico medico;
		
		try {
			System.out.println(puerto);
			socketDatosServidor = new ServerSocket(puerto);
			socketDatos = socketDatosServidor.accept();
			System.out.println("Conexion de Datos establecida");
			//Para mejora de mensajería en el canal de datos
			//pw = new PrintWriter(new OutputStreamWriter(socketDatos.getOutputStream()));
			
			switch (comando) {
				
			case "ADDPACIENTE":
					ois = new ObjectInputStream(socketDatos.getInputStream());
					paciente = (Paciente) ois.readObject();
					flag = CrudServer.addPaciente(paciente);
					if(flag) {
						System.out.println("OK " + comando + " 616" + " Paciente insertado");
						lineaEnvia = "OK " + comando + " 616" + " Paciente insertado";
					}else {
						lineaEnvia = "FAILED " + comando + " 616" + " Paciente no insertado";
						System.err.println("FAILED " + comando + " 316" + " Paciente insertado");
					}	
					break;
					
				case "UPDATEPACIENTE":
					
					ois = new ObjectInputStream(socketDatos.getInputStream());
					paciente = (Paciente) ois.readObject();
					System.out.println(paciente.getId());
					flag = CrudServer.updatePaciente(paciente,id);
					if(flag) {
						lineaEnvia = "OK " + comando + " 626" + " Paciente encontrado";
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia ="FAILED " + comando + " 326" + " Expediente modificado";
						System.err.println(lineaEnvia);
					}
					break;
				
				case "GETPACIENTE":	
					
					paciente = CrudServer.getListaPaciente().get(id);
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(paciente != null) {
						oos.writeObject(paciente);
						lineaEnvia = "OK " + comando + " 646" + " Paciente encontrado";
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia = "FAILED " + comando + " 346" + " Expediente modificado";
						System.err.println(lineaEnvia);
					}
					break;
					
				case "LISTPACIENTE":	
					HashMap<String, Paciente> lista;
					lista = CrudServer.getListaPaciente();
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(lista != null) {
						lineaEnvia = "OK " + comando + " 656" + " Expediente modificado";
						System.out.println("OK " + comando + " 656" + " Expediente modificado");
						oos.writeObject(lista);
					}else {
						lineaEnvia = "FAILED " + comando + " 356" + " Expediente modificado";
						System.err.println("FAILED " + comando + " 356" + " Expediente modificado");
					}

					break;
				
				case "ADDEXPEDIENTE":
					ois = new ObjectInputStream(socketDatos.getInputStream());
					expediente = (Expediente) ois.readObject();
					flag = CrudServer.addExpediente(expediente);
					if(flag) {
						lineaEnvia = "OK " + comando + " 717" + " Expediente insertado";
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia = "FAILED " + comando + " 317" + " Expediente no insertado";
						System.err.println(lineaEnvia);
					}

					break;
					
				
				
				case "GETEXPEDIENTE":	
					
					expediente = CrudServer.getListaExpediente().get(id);
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(expediente != null) {
						lineaEnvia ="OK " + comando + " 727" + " Expediente encontrado";
						oos.writeObject(expediente);
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia = "FAILED " + comando + " 327" + " No se ha podido encontrar ";
						System.err.println(lineaEnvia);
					}

					break;
					
				case "LISTEXPEDIENTE":	
					HashMap<String, Expediente> listaex;
					listaex = CrudServer.getListaExpediente();
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(listaex != null) {
						lineaEnvia = "OK " + comando + " 747" + " Lista enviada";
						oos.writeObject(listaex);
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia = "FAILED " + comando + " 347" + " Error al listar";
						System.err.println(lineaEnvia);
					}
					break;
					
				case "ADDMEDICO":
					ois = new ObjectInputStream(socketDatos.getInputStream());
					medico = (Medico) ois.readObject();
					flag = CrudServer.addMedico(medico);
					if(flag) {
						System.out.println("OK " + comando + " 818" + " Medico insertado");
						lineaEnvia = "OK " + comando + " 818" + " Medico insertado";
					}else {
						lineaEnvia = "FAILED " + comando + " 318" + " Medico no insertado";
						System.err.println("FAILED " + comando + " 318" + " Medico no insertado");
					}	
					break;
					
				case "UPDATEMEDICO":
					
					ois = new ObjectInputStream(socketDatos.getInputStream());
					medico = (Medico) ois.readObject();
					System.out.println(medico.getId());
					flag = CrudServer.updateMedico(medico,id);
					if(flag) {
						lineaEnvia = "OK " + comando + " 828" + " Medico modificado";
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia ="FAILED " + comando + " 838" + " Expediente ";
						System.err.println(lineaEnvia);
					}
					break;
				
				case "GETMEDICO":	
					
					medico = CrudServer.getListaMedicos().get(id);
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(medico != null) {
						oos.writeObject(medico);
						lineaEnvia = "OK " + comando + " 848" + " Medico encontrado";
						System.out.println(lineaEnvia);
					}else {
						lineaEnvia = "FAILED " + comando + " 348" + " Medico";
						System.err.println(lineaEnvia);
					}
					break;
					
				case "LISTMEDICO":	
					HashMap<String, Medico> listaMedico;
					listaMedico = CrudServer.getListaMedicos();
					oos = new ObjectOutputStream(socketDatos.getOutputStream());
					if(listaMedico != null) {
						lineaEnvia = "OK " + comando + " 868" + " Lista enviada";
						System.out.println("OK " + comando + " 868" + " Lista enviada");
						oos.writeObject(listaMedico);
					}else {
						lineaEnvia = "FAILED " + comando + " 368" + " Error al listar";
						System.err.println("FAILED " + comando + " 368" + " Error al listar");
					}

					break;	
				case "EXIT":
					break;
				default:
					lineaEnvia ="FAILED" + comando + " 030" + " Comando Incorrecto";
					System.out.println(lineaEnvia);
					break;
				}
			
			//pw.println(lineaEnvia);
			//pw.flush();
			//pw.close();
			
			if(oos !=null)
				oos.close();
			if(ois != null)
				ois.close();
			socketDatosServidor.close();
			socketDatos.close();
			//Tratamiento de Excepciones
		} catch (IOException | ClassNotFoundException | NullPointerException
				| ArrayIndexOutOfBoundsException e) {
			if(e instanceof ArrayIndexOutOfBoundsException )
				System.err.println("Error al introducir el numero correcto de parametros en el comando");
			if(e instanceof ClassNotFoundException)
				System.err.println("Error al enviar datos");
			if(e instanceof IOException)
				System.err.println("Error en la conexion");
			
		}
		
	}

	
	}
	
	

