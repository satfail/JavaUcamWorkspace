package Bancos;
import java.util.Scanner;

public class Principal {
	
	public static int buscarCuenta(Cuenta cuentas[], int n ) {
		int i = 0 , indice = 0;
		boolean flag = false;
		
		while( i < cuentas.length && flag == false) {
			
			if(cuentas[i].getNumeroCuenta() == n) {
				flag = true;
				indice = i;
	
			}
			else {
				i++;
			}
		}
		if (flag == false)
			indice = -1;
		
		return indice;
	}

	
	public static void main(String[] args) throws Exception {
		
		Scanner entrada = new Scanner(System.in);
		String nombre,apellido,dni;
		int numeroCuenta, nCuentas,menu = 0;
		double saldo;
		
		Cuenta cuentas[];
		Cliente cliente;
		int aux;
		
		
		System.out.print("Introduzca su nombre : ");
		nombre = entrada.nextLine();
		System.out.print("Introduzca su apellido :");
		apellido = entrada.nextLine();
		System.out.print("Introduzca su DNI : ");
		dni = entrada.nextLine();
		System.out.print("Introduzca el numero de cuentas que tiene : ");
		nCuentas = entrada.nextInt();
		cuentas = new Cuenta[nCuentas];
		
		for(int i = 0; i < cuentas.length; i++) {
			
			System.out.println("Introduzca los datos para la cuenta " + (i+1));
			System.out.print("Introduzca numero de Cuenta ");
			numeroCuenta = entrada.nextInt();
			System.out.print("Introduzca el saldo de la cuenta ");
			saldo = entrada.nextDouble();
			cuentas[i] = new Cuenta(numeroCuenta, saldo);
		}
		
		cliente = new Cliente(nombre,apellido,dni,cuentas);
		
		do {
			System.out.println("Pulse para Continuar...");
			System.in.read();
			System.out.println("\t Menu");
			System.out.println("1. Ingresar Dinero.");
			System.out.println("2. Retirar Dinero.");
			System.out.println("3. Consultar Dinero.");
			System.out.println("4. Salir");	
			System.out.print("Introduzca el valor del menu ");
			menu = entrada.nextInt();
			
			System.out.print("Introduzca el numero de cuenta sobre el que quiere operar : ");
			numeroCuenta = entrada.nextInt();
			switch(menu) {
			
			case 1:
				aux = buscarCuenta(cuentas, numeroCuenta);
				
				if(aux == -1)
					System.out.println("Cuenta no encontrda ");
				else {
					System.out.print("Introduzca cuanto dinero quiere ingresar : ");
					saldo = entrada.nextDouble();
					cuentas[aux].ingresarDinero(saldo);;
					
				}
				break;
				
			case 2:
				aux = buscarCuenta(cuentas, numeroCuenta);
				
				if(aux == -1)
					System.out.println("Cuenta no encontrda ");
				else {
					System.out.print("Introduzca cuanto dinero quiere retirar : ");
					saldo = entrada.nextDouble();
					cuentas[aux].retirarDinero(saldo);;
					
				}
				break;
				
			
			
			case 3:
				aux = buscarCuenta(cuentas, numeroCuenta);
				
				if(aux == -1)
					System.out.println("Cuenta no encontrda ");
				else {
					
					System.out.println("Su saldo es " + cuentas[aux].getSaldo());
				}
				break;
			case 4:
				System.out.println("Adios !!");
				break;
			default:
				System.out.println("Numero de menu incorrecto");
								
			}
		}while(menu!=4);
		
	}
}
