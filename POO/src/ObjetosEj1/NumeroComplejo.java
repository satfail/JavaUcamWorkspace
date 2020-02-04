package ObjetosEj1;
import java.util.Scanner;
public class NumeroComplejo {
	// z = 3 + 4i
	private float real;
	private float imaginaria;
	
	public NumeroComplejo(float a, float b) {
		
		this.real = a;
		this.imaginaria = b;
	}
	
	public NumeroComplejo() {
		
	}
	
	//Suma al que tengo creado
	public NumeroComplejo suma (NumeroComplejo complejo) {

		NumeroComplejo suma = new NumeroComplejo(real + complejo.getReal() , imaginaria + complejo.getImaginaria());
		
		return suma;
	}
	
	/* numero 1 = 3 + 4i
	 * numero 2 = 2 + 5i
	 * 
	 * mult = (3*2 - 4*5) + (3*5 + 4*2)i
	 */
	
	public NumeroComplejo multiplicacion(NumeroComplejo c) {
		
		NumeroComplejo mult = new NumeroComplejo((real*c.getReal())- (imaginaria*c.getImaginaria()), (real*c.getImaginaria())+ imaginaria*c.getReal());
		return mult;
		
	}
	
	public boolean comprobarIgualdad( NumeroComplejo c ) {
		
		boolean igualdad = false;
		if (real == c.real && imaginaria == c.imaginaria)
			igualdad = true;
		
		return igualdad;
		
	}
	
	public NumeroComplejo porEntero(int numero) {
		
		NumeroComplejo porEntero = new NumeroComplejo(numero*real, numero*imaginaria);
		return porEntero;
	}
	
	
	public float getReal() {
		return real;
	}
	public float getImaginaria() {
		return imaginaria;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner entrada = new Scanner(System.in);
		float real;
		float imaginaria;
		int menu = 0;
		int entero;
		NumeroComplejo c1,c2,suma,mult;
		
		System.out.print("Numero 1, parte Real : ");
		real = entrada.nextFloat();
		System.out.print(" Numero 1, parte imaginaria : ");
		imaginaria = entrada.nextFloat();
		c1 = new NumeroComplejo(real , imaginaria);
		System.out.print("Numero 2, parte Real : ");
		real = entrada.nextFloat();
		System.out.print(" Numero 2, parte imaginaria : ");
		imaginaria = entrada.nextFloat();
		c2 = new NumeroComplejo(real , imaginaria);
		do {
			System.out.println("Pulse para Continuar...");
			System.in.read();
			System.out.println("\t --Menu Complejo--");
			System.out.println(" 1. Suma");
			System.out.println(" 2. Multiplicacion");
			System.out.println(" 3. Comparar");
			System.out.println(" 4. Por Entero");
			System.out.println(" 5. Salir");
			menu = entrada.nextInt();
			
			switch(menu) {
			
				case 1: 
						suma = c1.suma(c2);
						System.out.println("Z = " + suma.real +" ," +suma.imaginaria+"i");
						break;
				case 2:
						mult = c1.multiplicacion(c2);
						System.out.println("Z = " + mult.real +" ," +mult.imaginaria+"i");
						break;
				//Hay que sobrecargar el metodo equals para ver que criterio usamos para la igualdad
				// por eso no sale igual2
				case 3: 
					System.out.println("Son iguales los numeros " + c1.comprobarIgualdad(c2) + " Con equal solo  "  + c1.equals(c2));
					break;
					
				case 4:
					System.out.print("Introduzca un numero entero : ");
					entero = entrada.nextInt();
					mult = c1.porEntero(entero);
					System.out.println("Z = " + mult.real +" ," +mult.imaginaria+"i");
					break;
					
				case 5: 
					System.out.println("Adios!");
					break;
					
				default:
					System.out.println("Operacion Incorrecta");
					break;		
			}
			
		}while(menu != 5);
		
		
		
	}
}
