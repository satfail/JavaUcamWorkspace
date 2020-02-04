package InterfazGrafica3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class VentanaEj3 extends JFrame {
	private JPanel panel;
	private JLabel etiqueta;
	private JButton bRojo,bVerde,bAzul;
	private int pulsado = 0; //Para sabre que boton se ha pulsado, 1 = rojo , 2  = verde , 3 = azul
	private int contRojo = 0, contVerde = 0, contAzul = 0 ;
	
	public VentanaEj3() {
		
		setSize(600, 400);
		setTitle("Ejercicio 3");
		setLocationRelativeTo(null);
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes() {
		crearPanel();
		crearEtiqueta();
		crearBotones();
		
	}
	
	private void crearPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		eventoPanel();
		
	}
	
	private void crearEtiqueta() {
		etiqueta = new JLabel();
		etiqueta.setBounds(20, 30, 500, 50);
		etiqueta.setText("Color : Rojo , Verde , Azul");
		etiqueta.setFont(new Font("arial", 3, 14));
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(etiqueta);
		
	}
	
	private void crearBotones() {
		bRojo = new JButton("Rojo");
		bRojo.setBounds(50, 230, 130, 50);
		bRojo.setForeground(Color.RED);
		panel.add(bRojo);
		
		bRojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pulsado =1;
				
			}
		});
		
		
		bVerde = new JButton("Verde");
		bVerde.setBounds(250, 230, 130, 50);
		bVerde.setForeground(Color.GREEN);
		panel.add(bVerde);
		
		bVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pulsado =2;
				
			}
		});
		
		
		
		bAzul = new JButton("Azul");
		bAzul.setBounds(450, 230, 130, 50);
		bAzul.setForeground(Color.BLUE);
		panel.add(bAzul);
		
		bAzul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pulsado =3;
				
			}
		});
		
		
		
		
	}
	
	public void eventoPanel() {
		
		MouseWheelListener eventoRueda = new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (pulsado != 0) { //Se ha pulsadoalgun boton
					
					if(pulsado == 1) {
							contRojo += e.getWheelRotation();
							if(contRojo < 0) {
								contRojo = 0;
							}
							if (contRojo > 255) {
								contRojo = 255;
							}
					}
					
					else if (pulsado == 2) {
						contVerde+= e.getWheelRotation();
						if(contVerde < 0) {
							contVerde = 0;
						}
						if (contVerde > 255) {
							contVerde = 255;
						}
					}
					
					else {
						contAzul += e.getWheelRotation();
						if(contAzul < 0) {
							contAzul = 0;
						}
						if (contAzul > 255) {
							contAzul = 255;
						}
					}
					etiqueta.setText("Color Rojo : " + contRojo + " Contador Verde : " + contVerde + " Contador Azul : " + contAzul);
					panel.setBackground(new Color(contRojo, contVerde, contAzul));
				}
				
			}
		};
		panel.addMouseWheelListener(eventoRueda);
	}
	
	
	public static void main(String[] args) {
		VentanaEj3 v3 = new VentanaEj3();
		v3.setVisible(true);
	}
	

}
