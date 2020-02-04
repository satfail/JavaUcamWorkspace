package edu.ucam.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import edu.ucam.pojos.Expediente;
import edu.ucam.pojos.Medico;
import edu.ucam.pojos.Paciente;


/**
 * 
 * @author Miguel Angel Gragera Garcia
 * Clase Cliente que inicia conexión con el servidor mediante comandos.
 * Establece dos conexiones una para comandos y otra para datos
 * 
 */
public class Cliente {
	
	static final int puertoMensajes = 2019;
	static final int puertoDatos = 2020;
	static final String ip = "localhost";
	static int contadorMensaje = 0;
	ObjectOutputStream oos ;
	ObjectInputStream ois;
	Socket socketMensajeCliente;
	static Scanner entrada = new Scanner(System.in);
	static PrintWriter pw;
	static BufferedReader br;
	//Esta comentado ya que se dijo en el anterior entregable que facilitaría la correción
	//se trata de la mejora incorporada para tratar los errores generados en el hilo de datos
	//static BufferedReader brDatos;
	
	static int id = 1;
	static String lineaEnvia;
	static String lineaRecibe = null;
	static String [] partes;

	
	/**
	 * Metodo para lanzar el Cliente
	 */
	public void lanzarCliente()  {
		String lineaEnvia;
		String lineaRecibe = null;
		Socket  socketDatosCliente;
		Paciente paciente;
		Expediente expediente;
		Medico medico;
		try {
			socketMensajeCliente = new Socket(ip, puertoMensajes);
			pw = new PrintWriter(new OutputStreamWriter(socketMensajeCliente.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socketMensajeCliente.getInputStream()));
			System.out.println("Conexion establecida con el Servidor");
			
		/**
		 * Comandos
		 */
			if(login()) {
					do {
						
						System.out.println("Introduzca el siguente comando : ");
						System.out.print(">");
						lineaEnvia = id + " " + entrada.nextLine();
						
						
						try {

							pw.println(lineaEnvia);
							pw.flush();
							lineaRecibe = br.readLine(); 
							partes = lineaRecibe.split(" ");
							//lineaRecibe = 	 ok + comando + comandocliente + ip + datos
							switch (partes[2]) {
							case "01ADDPACIENTE":
								
								paciente = datosPaciente();
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								oos = new ObjectOutputStream(socketDatosCliente.getOutputStream());		
								oos.writeObject(paciente);
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								socketDatosCliente.close();
								break;
								
							case "01UPDATEPACIENTE":
								paciente= updatePaciente();
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								oos = new ObjectOutputStream(socketDatosCliente.getOutputStream());		
								oos.writeObject(paciente);
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								//brDatos.close();
								socketDatosCliente.close();
								break;
								
							case "01GETPACIENTE":
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								paciente = (Paciente) ois.readObject();
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								System.out.println("-----------------------------------------------");
								System.out.println( "Nombre :" +paciente.getNombre() +" " + paciente.getApellidos() + " Fecha Nacimiento : " 
										+ paciente.getFechaNacimiento());
								System.out.println("-----------------------------------------------");
								//brDatos.close();
								socketDatosCliente.close();
								break;						
								
								
							case "01REMOVEPACIENTE":
								System.out.println(lineaRecibe);
								break;
								
							case "01LISTPACIENTE" :
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								HashMap<String, Paciente> pLista = (HashMap<String, Paciente>) ois.readObject();
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								for(Entry<String, Paciente> iterPaciente : pLista.entrySet()) {
									System.out.println("-----------------------------------------------");
									System.out.println( "ID : " + iterPaciente.getKey() + "\nNombre :" + iterPaciente.getValue().getNombre() +
											" " + iterPaciente.getValue().getApellidos() + " Fecha Nacimiento : " 
											+ iterPaciente.getValue().getFechaNacimiento());
								}
								//brDatos.close();
								break;
								
							case "01COUNTPACIENTE":
								System.out.println(lineaRecibe);
								break;
								
							
							case "02ADDEXPEDIENTE":
								 expediente = new Expediente();
								 expediente.setMedico(new Medico("8", "Jaun", "test", "tst"));
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								oos = new ObjectOutputStream(socketDatosCliente.getOutputStream());		
								oos.writeObject(expediente);
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								//brDatos.close();
								socketDatosCliente.close();
								break;
								
								
							case "02GETEXPEDIENTE":
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								 expediente = (Expediente) ois.readObject();

								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								try {
									System.out.println("-----------------------------------------------");
									System.out.println( "Paciente : " + expediente.getPaciente().getNombre() + 
										" " +expediente.getPaciente().getApellidos() +
										"\nMedico : " +expediente.getMedico().getNombre() + " " + expediente.getMedico().getApellidos()+
										" Especialidad : " + expediente.getMedico().getEspecialidad() + 
										"\nTratamiento : " + expediente.getTramientos().get(0).getDescripcion());									
									System.out.println("-----------------------------------------------");
								}catch (NullPointerException eNullPointerException) {
									System.out.println("Datos de Expediente Incompletos");
									System.out.println("-----------------------------------------------");
								}
								//brDatos.close();
								socketDatosCliente.close();
								break;
							
							case "02REMOVEEXPEDIENTE":
								System.out.println(lineaRecibe);
								break; 
								
							case "02LISTEXPEDIENTE":
								
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								HashMap<String, Expediente> eLista = (HashMap<String, Expediente>) ois.readObject();
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								for(Entry<String, Expediente> e : eLista.entrySet()) {
									try {
										System.out.println("-----------------------------------------------");
										System.out.println( "ID : " +  e.getKey() + "\nPaciente : " + e.getValue().getPaciente().getNombre() + 
											" " +e.getValue().getPaciente().getApellidos() +
											"\nMedico : " + e.getValue().getMedico().getNombre() + " " + e.getValue().getMedico().getApellidos()+
											" Especialidad : " + e.getValue().getMedico().getEspecialidad() + 
											"\nTratamiento : " + e.getValue().getTramientos().get(0).getDescripcion());									
						
									}catch (NullPointerException eNullPointerException) {
										System.out.println("ID : " + e.getKey() +" Datos de Expediente Incompletos");
									}
								}
								//brDatos.close();
								socketDatosCliente.close();
								break;
								
							case "02COUNTEXPEDIENTE":
								System.out.println(lineaRecibe);
								break;
							
							case "02ADDPACIENTE2EXP":
								System.out.println(lineaRecibe);
								break;
							
								
							case "02REMOVEPACIENTEFROMEXP":
								System.out.println(lineaRecibe);
								break;
								
							case "02ADDMEDICO2EXP":
								System.out.println(lineaRecibe);
								break;
							
							case "02REMOVEMEDICOFROMEXP":
								System.out.println(lineaRecibe);
								break;
							case "02ADDTRATAM2EXP":
								System.out.println(lineaRecibe);
								break;
							
							case "02REMOVETRATAMFROMEXP":
								System.out.println(lineaRecibe);
								break;
							
							case "03ADDMEDICO":
								
								medico = datosMedico();
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								oos = new ObjectOutputStream(socketDatosCliente.getOutputStream());		
								oos.writeObject(medico);
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								socketDatosCliente.close();
								break;
								
							case "03UPDATEMEDICO":
								medico= updateMedico();
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								oos = new ObjectOutputStream(socketDatosCliente.getOutputStream());		
								oos.writeObject(medico);
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								//brDatos.close();
								socketDatosCliente.close();
								break;
								
							case "03GETMEDICO":
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								medico = (Medico) ois.readObject();
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								System.out.println("-----------------------------------------------");
								System.out.println( "Nombre :" + medico.getNombre() +
										" " + medico.getApellidos() + " Especialidad : " + medico.getEspecialidad());
								System.out.println("-----------------------------------------------");
								//brDatos.close();
								socketDatosCliente.close();
								break;						
								
								
							case "03REMOVEMEDICO":
								System.out.println(lineaRecibe);
								break;
								
							case "03LISTMEDICO" :
								socketDatosCliente = new Socket(partes[3], Integer.parseInt(partes[4]));
								ois = new ObjectInputStream(socketDatosCliente.getInputStream());
								HashMap<String, Medico> mLista = (HashMap<String, Medico>) ois.readObject();
								//brDatos =  new BufferedReader(new InputStreamReader(socketDatosCliente.getInputStream()));
								//System.out.println(brDatos.readLine());
								for(Entry<String, Medico> iterMedico : mLista.entrySet()) {
									System.out.println("-----------------------------------------------");
									System.out.println( "ID : " + iterMedico.getKey() + "\nNombre :" + iterMedico.getValue().getNombre() +
											" " + iterMedico.getValue().getApellidos() + " Especialidad : " + iterMedico.getValue().getEspecialidad());
								}
								//brDatos.close();
								break;
								
							case "03COUNTMEDICO":
								System.out.println(lineaRecibe);
								break;	
							default:
								System.out.println(lineaRecibe);
								break;
								
							}
							
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						id++;
					}while(!(partes[0].contains("ERROR") || partes[2].contains("EXIT")));
			}else {
				System.out.println("Usuario Incorrecto");
			}
			
			socketMensajeCliente.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Método de Login
	 * @return Retorna true si el cliente se ha logueado corrrectamente
	 */
	
	public static boolean login() {
		boolean flag = false;
		System.out.println("<USER> usuario");
		do {
			lineaEnvia = id + " " + entrada.nextLine();
			pw.println(lineaEnvia);
			pw.flush();
			id++;
			try {
				System.out.println("<USER> usuario");
				lineaRecibe = br.readLine();
				partes = lineaRecibe.split(" ");
				System.out.println(lineaRecibe);
				if(partes[0].equals("OK")) {
					do {
						System.out.println("<PASS> password");
						lineaEnvia = id + " " + entrada.nextLine();
						pw.println(lineaEnvia);
						pw.flush();
						id++;
						lineaRecibe = br.readLine();
						System.out.println(lineaRecibe);
						partes = lineaRecibe.split(" ");
						if(partes[0].equals("OK")) {
							flag = true;
						}
					}while(!flag);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(!flag);

		return flag;
	}
	/**
	 * Menu de comandos, accesible desde el comando HELP
	 */
	public static void menuComandos() { // Hacer submenu para que no salga el chorro, gestion de cada cosa
		int menu;
		do {
			System.out.println("");
			System.out.println("/ ************************************* /");
			System.out.println(" ** COMANDOS **");
			System.out.println("/ ************************************* /");
			System.out.println("1. GESTION PACIENTE");
			System.out.println("2. GESTION EXPEDIENTE");
			System.out.println("3. GESTION MEDICO");
			System.out.println("4. SALIR");
			System.out.println("/ ************************************* /");
			System.out.print(">");
			menu = entrada.nextInt();
			System.out.println("");
			System.out.println(" ** COMANDOS **");
			System.out.println("/ ************************************* /");
			switch (menu) {
			case 1:
				System.out.println("P1. ADDPACIENTE");
				System.out.println("P2. UPDATEPACIENTE P+id");
				System.out.println("P3. GETPACIENTE P+id");
				System.out.println("P4. REMOVEPACIENTE P+id");
				System.out.println("P5. LISTPACIENTE");
				System.out.println("P6. COUNTPACIENTE");
				break;
			case 2:
				System.out.println("E1. ADDEXPEDIENTE");
				System.out.println("E2. UPDATEEXPEDIENTE E+id");
				System.out.println("E3. GETEXPEDIENTE E+id");
				System.out.println("E4. REMOVEEXPEDIENTE E+id");
				System.out.println("E5. LISTPACIENTE");
				System.out.println("E6. COUNTEXPEDIENTE");
				break;

			default:
				break;
			}
		}while(menu!=4);
		
	}
	/**
	 * Metodo para crear pacientes
	 * @return retorna un Paciente
	 */
	public static Paciente datosPaciente() {
		String nombre ,apellidos ,dateString;
		Date fechaNac = null;
		int contadorPaciente = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Introduzca los datos del paciente :");
		System.out.print("Nombre : "); nombre = entrada.nextLine();
		System.out.print("Apellidos : "); apellidos = entrada.nextLine();
		System.out.print("Fecha (dd/mm/yyyy):  ");  dateString = entrada.nextLine();
		try {
			fechaNac = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paciente paciente = new Paciente(null, nombre, apellidos, fechaNac); ///Calculo ID en hilo de datos
		
		return paciente;
	}
	/**
	 * Metodo para modificar pacientes
	 * @return Paciente
	 * @throws ParseException
	 */
 	public static Paciente updatePaciente() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaString;
 		System.out.println("Introduzca la ID del paciente a Cambiar");
 		Paciente paciente =new Paciente();
 		System.out.print("ID :"); paciente.setId(entrada.nextLine());
 		System.out.print("Nombre :"); paciente.setNombre(entrada.nextLine());
 		System.out.print("Apellidos :"); paciente.setApellidos(entrada.nextLine());
 		System.out.print("Fecha (dd/mm/yyyy) :"); fechaString = entrada.nextLine(); 
 		paciente.setFechaNacimiento(sdf.parse(fechaString));
 		return paciente;
 	}
	/**
	 * Método para crear medico
	 * @return Medico
	 */
 	public static Medico datosMedico() {
		String nombre ,apellidos ,especialidad;
		System.out.println("Introduzca los datos del paciente :");
		System.out.print("Nombre : "); nombre = entrada.nextLine();
		System.out.print("Apellidos : "); apellidos = entrada.nextLine();
		System.out.print("Espcecialidad :  ");  especialidad = entrada.nextLine();
		Medico medico  = new Medico(null, nombre, apellidos, especialidad);///Calculo ID en hilo de datos
		return medico;
	}
 	/**
 	 * Método para modificar medicos
 	 * @return Medico
 	 * @throws ParseException
 	 */
 	public static Medico updateMedico() throws ParseException {

 		System.out.println("Introduzca la ID del paciente a Cambiar");
 		Medico medico =new Medico();
 		System.out.print("ID :"); medico.setId(entrada.nextLine());
 		System.out.print("Nombre :"); medico.setNombre(entrada.nextLine());
 		System.out.print("Apellidos :"); medico.setApellidos(entrada.nextLine());
		System.out.print("Espcecialidad :  "); medico.setEspecialidad(entrada.nextLine()); 
 		return medico;
 	}	
}

