package InterfazGrafica3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaEj1 extends JFrame {
	
	private JPanel panel;
	private JButton b1;
	private JLabel etiqueta;
	private  int contador = 0;
	
	public VentanaEj1() {
		setSize(500,500);
		setTitle("Contador de Clicks");
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes() {
		crearPanel();
		crearEtiqueta();
		crearBoton();
	}
	
	private void crearPanel() {
		
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
	}
	
	private void crearEtiqueta() {
		
		etiqueta = new JLabel("Pulse el boton ");
		etiqueta.setBounds(30,10,200,30);
		etiqueta.setFont(new Font("cooper black", 1, 12));
		panel.add(etiqueta);
		
	}
	
	private void crearBoton() {
		
		b1 = new JButton("Continuar");
		b1.setBounds(350,80, 140,40);
		panel.add(b1);
		
		accionBoton();
	}
	
	private void accionBoton() {
		ActionListener escuchaBoton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contador++;
				if (contador == 1) {
					etiqueta.setText("Ha pulsado 1 vez");
				}
				else {
					etiqueta.setText("Ha pulsado el boton " + contador + " veces");
				}
				
			}
		};
		
		
		b1.addActionListener(escuchaBoton);
	}
	
	public static void main(String[] args) {
		VentanaEj1 v1 = new VentanaEj1();
		v1.setVisible(true);
	}

}
