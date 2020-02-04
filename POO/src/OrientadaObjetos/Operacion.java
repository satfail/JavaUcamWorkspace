package OrientadaObjetos;

import javax.swing.JOptionPane;

public class Operacion {
	
	//Atributos
	float numero1, numero2;
	
	
	//Metodos
	
	public void leerNumeros() {
		numero1 = Float.parseFloat(JOptionPane.showInputDialog("Introduzca Numero 1 : "));
		numero2 = Float.parseFloat(JOptionPane.showInputDialog("Introduzca Numero 2 : "));
		
	}
	
	public float sumar(float n1, float n2) {
		
		float suma = n1 + n2;
		return suma;
	}
	
	public float restar(float n1, float n2) {
		
		float resta = n1 - n2;
		return resta;
	}

	public void mostrar(float suma , float resta) {
		System.out.println("La suma vale : " + suma);
		System.out.println("La resta vale : " + resta);
	}
	
	public static void main(String[] args) {
		
		Operacion op = new Operacion();
		float suma, resta;
		op.leerNumeros();
		suma = op.sumar(op.numero1, op.numero2);
		resta = op.restar(op.numero1, op.numero2);
		op.mostrar(suma , resta);
	}
}
