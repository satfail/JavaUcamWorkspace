package edu.ucam.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.TreeMap;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;


/**
 * 
 * @author Miguel Angel Gragera Garcia
 * Hilo que recibe un socket de conexion, se crean hilo de datos para 
 * enviar datos
 */


public class HiloMensajeria extends Thread {
	
	private Socket socketMensajeria;
	static int contadorMensaje = 0;
	static int puertoDatos = 2020;
	static String id;
	PrintWriter pw;
	BufferedReader br;
	
	public HiloMensajeria(Socket socketMensajeria) {

		this.socketMensajeria = socketMensajeria;

	}
	
	
	public void run() {
		
		HiloDatos hilodatos;
		
		try {
			String lineaEnvia ="";
			String lineaRecibe = "";
			String[] partes;
			boolean flag = false;
			pw = new PrintWriter(new OutputStreamWriter(socketMensajeria.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socketMensajeria.getInputStream()));
			//Comprobar Usuario y Contraseña
			do {
				lineaRecibe = br.readLine();
				System.out.println("Mensaje recibido : " + lineaRecibe);
				partes = lineaRecibe.split(" ");
				if(partes.length ==3) {
					if(partes[1].equals("USER")){
						if(partes[2].equalsIgnoreCase("admin")) {
							lineaEnvia = "OK " + partes[0] + " 701 "+ " <PASS> password";
							flag = true;
						}else {
							lineaEnvia = "FAILED " + partes[0] + " 301 " +" Mensaje incorrecto. ID USER usuario";
							System.err.println("Usuario Incorrecto");
						}
					}else {
						lineaEnvia = "FAILED " + partes[0] + " 301 " +" Mensaje incorrecto. ID USER usuario";
						System.err.println("Mensaje Incorrecto");
					}
				}else {
					lineaEnvia = "FAILED " + partes[0] + " 302 " +" Mensaje incorrecto. ID USER usuario";
					System.err.println("Longitud del mensaje Incorrecta");
				}
				pw.println(lineaEnvia);
				pw.flush();
			}while(!flag);
			
			flag = false;
			
			

			do {
				lineaRecibe = br.readLine();
				System.out.println("Mensaje recibido : " + lineaRecibe);
				partes = lineaRecibe.split(" ");
				if(partes.length == 3) {
					if(partes[1].equals("PASS")) {
						if(partes[2].equals("admin")) {
							lineaEnvia = "OK " + partes[0] + " 710 " + " envie los comandos";
							flag = true;
						}else {
							lineaEnvia = "FAILED " + partes[0] + " 311 " +" Mensaje incorrecto. ID USER usuario";
							System.err.println("Contraseña Incorrecta");
						}
						
					}else {
						lineaEnvia = "FAILED " + partes[0] + " 311 " +" Mensaje incorrecto. ID USER usuario";
						System.err.println("Mensaje Incorrecto");
					}
					
				}else {
					lineaEnvia = "FAILED " + partes[0] + " 311 " +" Mensaje incorrecto. ID USER usuario";
					System.err.println("Longitud del mensaje Incorrecta");
				}
				pw.println(lineaEnvia);
				pw.flush();
			}while(!flag);
			
			flag = false;
			
			do {
				///lineaRecibe = idmensaje + comando + idcomando
				lineaRecibe = br.readLine();
				partes = lineaRecibe.split(" ");
				if(partes.length >=2) {
				
					try {
						switch (partes[1]) {
						
						/*Gestion de Pacientes*/
							case "ADDPACIENTE":
								/// ok + comando + comandocliente + ip + datos
								lineaEnvia = "OK " + partes[0] + " 01ADDPACIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos);
								hilodatos.start();
								puertoDatos++;
								break;
							case "UPDATEPACIENTE":
								lineaEnvia = "OK " + partes[0] + " 01UPDATEPACIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], partes[2],puertoDatos); ///(comando, id)
								hilodatos.start();
								puertoDatos++;
								break;
							case "GETPACIENTE":
								lineaEnvia = "OK " + partes[0] + " 01GETPACIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], partes[2],puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
							case "REMOVEPACIENTE":
								Paciente pacienteBorrado = CrudServer.getListaPaciente().remove(partes[2]);
								if (pacienteBorrado != null)
									lineaEnvia = "OK " + partes[0] + " 01REMOVEPACIENTE " + "ID " + pacienteBorrado.getId() + " borrado" ;
								else {
									lineaEnvia = "ERROR " + partes[0] + " 01REMOVEPACIENTE " + " No autorizado";
									System.err.println("ERROR " + " 030");
								}
								break;
							case "LISTPACIENTE":
								lineaEnvia = "OK " + partes[0] + " 01LISTPACIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
								
							case "COUNTPACIENTE":
								lineaEnvia = "OK " + partes[0] + " 01COUNTPACIENTE "  
										+ CrudServer.getListaPaciente().values().size();
								System.out.println("El sistema tiene : " + CrudServer.getListaPaciente().values().size() + " pacientes");
								break;
								
							/*GESTION EXPEDIENTE*/
							
							case "ADDEXPEDIENTE": 
								
								lineaEnvia = "OK " + partes[0] + " 02ADDEXPEDIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos);
								hilodatos.start();
								puertoDatos++;
								break;
	
							case "GETEXPEDIENTE":
								lineaEnvia = "OK " + partes[0] + " 02GETEXPEDIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], partes[2],puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
							case "REMOVEEXPEDIENTE":
								Expediente expedienteeBorrado = CrudServer.getListaExpediente().remove(partes[2]);
								if (expedienteeBorrado != null)
									lineaEnvia = "OK " + partes[0] + " 02REMOVEEXPEDIENTE " + "ID " + expedienteeBorrado.getId() + " borrado" ;
								else {
									lineaEnvia = "ERROR " + partes[0] + " 02REMOVEEXPEDIENTEE " + " No autorizado";
									System.err.println("ERROR " + " 030");
								}
								break;
							case "LISTEXPEDIENTE":
								lineaEnvia = "OK " + partes[0] + " 02LISTEXPEDIENTE " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
								
							case "COUNTEXPEDIENTE":
								lineaEnvia = "OK " + partes[0] + " 02COUNTEXPEDIENTE "  
										+ CrudServer.getListaExpediente().values().size();
								System.out.println("El sistema tiene : " + CrudServer.getListaPaciente().values().size() + " pacientes");
								break;	
								
							case "ADDPACIENTE2EXP":
								//try {
								flag = CrudServer.addPacExp(partes[2], partes[3]);
								System.out.println(CrudServer.getListaExpediente().get(partes[3]).getPaciente().getNombre());
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02ADDPACIENTE2EXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al insertar el Paciente";
									System.err.println(lineaEnvia);
								}
								
								break;	
								
								
							case "REMOVEPACIENTEFROMEXP":
								
								flag = CrudServer.removePacExp(partes[2], partes[3]);
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02REMOVEPACIENTEFROMEXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al insertar el Paciente";
									System.err.println(lineaEnvia);
								}
								break;	
							
							case "ADDMEDICO2EXP":
								
								flag = CrudServer.addMedExp(partes[2], partes[3]);
								System.out.println(CrudServer.getListaExpediente().get(partes[3]).getMedico().getNombre());
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02ADDMEDICO2EXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al insertar el Medico";
									System.err.println(lineaEnvia);
								}
								break;	
								
								
							case "REMOVEMEDICOFROMEXP":
								
								flag = CrudServer.removeMedExp(partes[2], partes[3]);
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02REMOVEMEDICOFROMEXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al eliminar el Medico";
									System.err.println(lineaEnvia);
								}
								break;	
							
							case "ADDTRATAM2EXP":
								
								flag = CrudServer.addTrataExp(partes[2], partes[3]);
								System.out.println(CrudServer.getListaExpediente().get(partes[3]).getTramientos().get(0).getDescripcion());
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02ADDTRATAM2EXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al insertar el Medico";
									System.err.println(lineaEnvia);
								}
								break;	
								
								
							case "REMOVETRATAMFROMEXP":
								
								flag = CrudServer.removeMedExp(partes[2], partes[3]);
								if(flag) {
									lineaEnvia = "OK " + partes[0] + " 02REMOVETRATAMFROMEXP ";
									System.out.println(lineaEnvia);
								}else {
									lineaEnvia = "FAILED " + partes[0] + " 376" + " Error al eliminar el Mdico";
									System.err.println(lineaEnvia);
								}
								break;	
								
							case "ADDMEDICO":
								lineaEnvia = "OK " + partes[0] + " 03ADDMEDICO " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos);
								hilodatos.start();
								puertoDatos++;///Hacer TreeMap para que este ordenado y pueda buscar los libres, como el ID pacientes y demas
								break;
							case "UPDATEMEDICO":
								lineaEnvia = "OK " + partes[0] + " 03UPDATEMEDICO " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], partes[2],puertoDatos); ///(comando, id)
								hilodatos.start();
								puertoDatos++;
								break;
							case "GETMEDICO":
								lineaEnvia = "OK " + partes[0] + " 03GETMEDICO " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], partes[2],puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
							case "REMOVEMEDICO":
								Medico medicoBorrado = CrudServer.getListaMedicos().remove(partes[2]);
								if (medicoBorrado != null)
									lineaEnvia = "OK " + partes[0] + " 03REMOVEMEDICO " + "ID " + medicoBorrado.getId() + " borrado" ;
								else {
									lineaEnvia = "ERROR " + partes[0] + " 03REMOVEMEDICO " + " No autorizado";
									System.err.println("ERROR " + " 030");
								}
								break;
							case "LISTMEDICO":
								lineaEnvia = "OK " + partes[0] + " 03LISTMEDICO " + Servidor.ip + " " + puertoDatos;
								hilodatos = new HiloDatos(partes[1], "",puertoDatos); 
								hilodatos.start();
								puertoDatos++;
								break;
								
							case "COUNTMEDICO":
								lineaEnvia = "OK " + partes[0] + " 03COUNTMEDICO "  
										+ CrudServer.getListaPaciente().values().size();
								System.out.println("El sistema tiene : " + CrudServer.getListaPaciente().values().size() + " pacientes");
								break;
							
								
							case "EXIT":
								lineaEnvia = "OK " + partes[0] + " EXIT";
								break;
							default:
								lineaEnvia = "FAILED " + " 030 DEFAULTFAIL Error al introducir comandos";
								System.out.println(lineaEnvia);
								break;
						
	
					
					}
				}catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Error al introducir parametros en el comando");
				}
				}else {
					lineaEnvia = "FAILED " + partes[0]+ " 030 " + " Mensaje incorrecto. Comando Incorrecto";
					System.err.println(lineaEnvia);
				}
				pw.println(lineaEnvia);
				pw.flush();
				System.out.println(partes[1]);
			}while(!partes[1].equals("EXIT"));


		} catch (IOException |  NullPointerException
				| ArrayIndexOutOfBoundsException e) {

			if(e instanceof IOException)
				System.err.println("Error en la conexion");
			e.printStackTrace();
		}
	}
	
}
