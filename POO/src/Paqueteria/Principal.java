package Paqueteria;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args)  {
		
		Scanner entrada = new Scanner(System.in);
		int menu = 0;
		int contadorSucursal = 0;
		int contadorPaquete= 0;
		int indiceSucursal = 0;
		int indicePaquete = 0;
		double precio = 0;
		
		
		//Sucursal
		Sucursal sucursal[] = new Sucursal[50];
		Paquete paquete[] = new Paquete[100];
		int numSucursal;
		String direccion;
		String ciudad;
		
		//Paquete
		int numeroPaquete;
		String dni;
		double peso;
		int prioridad;
		
		do {

			//System.in.read();
			System.out.println("\t Menu");
			System.out.println("1. Crear Sucursal");
			System.out.println("2. Enviar Paquete");
			System.out.println("3. Consultar Sucursal");
			System.out.println("4. Consultar Paquete");
			System.out.println("5. Mostrar todas las Sucursales");
			System.out.println("6. Mostar todos los paquetes");
			System.out.println("7. Salir");
			
			menu = entrada.nextInt();
			
			switch(menu) {
			
			case 1: 
				entrada.nextLine();
				System.out.print("Introduzca numero de sucursal : ");
				numSucursal = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduzca la Direccion : ");
				direccion = entrada.nextLine();
				System.out.println("Introduzca la Ciudad : ");
				ciudad = entrada.nextLine();
				sucursal[contadorSucursal] = new Sucursal(numSucursal,direccion,ciudad);
				contadorSucursal++;
				break;
			case 2:
				System.out.print("Introduzca el numero de Sucursal ");
				numSucursal = entrada.nextInt();
				indiceSucursal = encontrarSucursal(contadorSucursal, sucursal, numSucursal);
				if (indiceSucursal == -1)
					System.out.println("Lo siento la sucursal no existe");
				else {
					System.out.print("Introduzca el numero de paquete : ");
					numeroPaquete = entrada.nextInt();
					entrada.nextLine();
					System.out.print("Introduzca DNI : ");
					dni = entrada.nextLine();
					System.out.print("Introduzca el peso : ");
					peso = entrada.nextDouble();
					System.out.println("Introduzca Prioridad (0 = normal , 1= alta , 2= Express : ");
					prioridad = entrada.nextInt();
					paquete[contadorPaquete] = new Paquete(numeroPaquete, dni, peso, prioridad);
					precio = sucursal[indiceSucursal].calcular_precio(paquete[contadorPaquete]);
					System.out.println("El precio del paquete es : " + precio);
					contadorPaquete++;
				
				}
				
				break;
			case 3:
				System.out.print("Introduzca el numero de Sucursal ");
				numSucursal = entrada.nextInt();
				indiceSucursal = encontrarSucursal(contadorSucursal, sucursal, numSucursal);
				if (indiceSucursal == -1)
					System.out.println("Lo siento la sucursal no existe");
				else 
					System.out.println(sucursal[indiceSucursal].mostrarDatosSucursal());
				break;
				
			case 4:
				entrada.nextLine();
				System.out.print("Introduzca el Numero del Paquete ");
				numeroPaquete = entrada.nextInt();
				indicePaquete = encontrarPaquete(contadorPaquete, paquete,numeroPaquete);
				if(indicePaquete == -1)
					System.out.println("El paquete no existe");
				else {
					System.out.println(paquete[indicePaquete].mostrarDatosPaquete());
				}
				break;
			case 5:
				for (int i = 0; i < contadorSucursal ; i++) {
					
					System.out.println(sucursal[i].mostrarDatosSucursal());
				}
				break;
			case 6:
				for (int i = 0; i < contadorPaquete ; i++) {
					
					System.out.println(paquete[i].mostrarDatosPaquete());
				}
				break;
			case 7 : 
				System.out.println("Adios!");
				break;
			default:
				System.out.println("Entrada para menu incorrecta");
					
					
			
				
			
			}
			
		}while(menu!= 7);
		
		
	}
	
	public static int encontrarSucursal(int contador, Sucursal s[], int num) {
		
		int indice = 0;
		boolean flag = false;
		for(int i = 0; i < contador; i++) {
			
			if(s[i].getNumSucursal() == num ) {
				indice = i;
				flag=true;
			}
			
		}
		
		if (flag == false) {
			
			indice = -1;
		}
		
		return indice;
	}
	
	public static int encontrarPaquete(int contador, Paquete p[], int num) {
		
		int indice = 0;
		boolean flag = false;
		System.out.println(contador + " " + p[0].getNumeroPaquete() +" " +num);
		
		for(int i = 0; i < contador; i++) {
			
			if( (p[i].getNumeroPaquete()) == num ) {
				
				indice = i;
				flag=true;
			}
			
		}
		
		if (flag == false) {
			
			indice = -1;
		}
		
		return indice;
	}
}
