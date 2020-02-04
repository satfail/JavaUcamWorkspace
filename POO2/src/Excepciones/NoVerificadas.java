package Excepciones;

import javax.swing.JOptionPane;

public class NoVerificadas {
	
	public void operaciones() { //Aqui hay un error aunque java no me pide que la maneje
		
		
		int x = 5;
		int y = 0;
		int resultado = x/y;
		System.out.println(resultado);
		
	}
	
	public static void main(String[] args) {
		
		NoVerificadas prueba = new NoVerificadas();
		try {
			prueba.operaciones();
		}
		catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Esta dividiendo entre 0");
		}
	}

}
