package Introduccion;

import java.util.Scanner;

public class Operadores {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		float numero1,numero2,operacion;
		
		System.out.println("Introduzca dos numeros : ");
		numero1 = entrada.nextFloat();
		numero2 = entrada.nextFloat();
		
		operacion = numero1 + numero2;
		System.out.println("Suma : " + operacion);
		operacion= numero1 - numero2;
		System.out.println("Resta : " + operacion);
		operacion = numero1*numero2;
		System.out.println("Multiplicacion : " + operacion);
		operacion = numero1/numero2;
		System.out.println("Division : " + operacion);
		operacion = numero1%numero2;
		System.out.println("Resto : "+ operacion);
		System.out.println("---------Incremento/Decremento----------");
		int x = 5,y;
		y = x++;
		System.out.println(y);
		System.out.println(x);
		x = 5;
		y = ++x;
		System.out.println(y);
		System.out.println(x);
		System.out.println("---------Con clase MATH----------");
		System.out.println("Raiz de Numero 1 : " + Math.sqrt(numero1));
		System.out.println("Elevamos N1 a N2 : " + Math.pow(numero1, numero2));
		System.out.println("Redondeamos a int : " + Math.round(numero1));
		System.out.println("Random : " + Math.random());
	}
}
