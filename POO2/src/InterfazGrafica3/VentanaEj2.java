package InterfazGrafica3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEj2 extends JFrame {
	
	private JPanel panel;
	private JLabel etiqueta,imagen;
	private JRadioButton rb1,rb2,rb3,rb4;
	
	public VentanaEj2() {
		
		setSize(700,400);
		setTitle("Ejercicio2");
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	private void iniciarComponentes() {
		crearPanel();
		crearEtiqueta();
		crearRadioBoton();
	}
	
	private void crearPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
	}
	
	private void crearEtiqueta() {
		
		etiqueta = new JLabel();
		etiqueta.setText("Escoja su deporte Favorito : ");
		etiqueta.setBounds(20, 20, 220, 30);
		etiqueta.setFont(new Font("arial", 3, 15));
		panel.add(etiqueta);
	}
	
	private void crearRadioBoton() {
		rb1 = new JRadioButton("Futbol");
		rb2 = new JRadioButton("Baloncesto");
		rb3 = new JRadioButton("Tenis");
		rb4 = new JRadioButton("Natacion");
		
		rb1.setBounds(20, 80, 100, 30);
		panel.add(rb1);
		rb2.setBounds(20, 120, 100, 30);
		panel.add(rb2);
		rb3.setBounds(20, 160, 100, 30);
		panel.add(rb3);
		rb4.setBounds(20, 200, 100, 30);
		panel.add(rb4);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rb1);
		grupo.add(rb2);
		grupo.add(rb3);
		grupo.add(rb4);
		
		eventoAccion();
		
	}
	
	private void eventoAccion() {
		imagen = new JLabel();
		imagen.setBounds(200, 80, 300, 200);
		panel.add(imagen);
	    ImageIcon imagenFutbol = new ImageIcon("futbol.jpeg");
		ImageIcon imagenBasket = new ImageIcon("basket.jpg");
		ImageIcon imagenTenis = new ImageIcon("tenis.jpg");
		ImageIcon imagenNatacion = new ImageIcon("natacion.jpg");
		
		ActionListener evento1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imagenFutbol.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
					
			}
		};
		
		ActionListener evento2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imagenBasket.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
				
			}
		};
		
		ActionListener evento3 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imagenTenis.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
				
			}
		};
		
		ActionListener evento4 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imagenNatacion.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
				
			}
		};
		
		
		
		rb1.addActionListener(evento1);
		rb2.addActionListener(evento2);
		rb3.addActionListener(evento3);
		rb4.addActionListener(evento4);
		
	}
	
	public static void main(String[] args) {
		VentanaEj2 v2 = new VentanaEj2();
		v2.setVisible(true);
	}

}
