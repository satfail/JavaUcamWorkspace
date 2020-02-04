package InterfazGrafica2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

public class Ventana extends JFrame{
	
	private JPanel panel;
	private JLabel saludo; //Este es para la accion del luego
	private JLabel etiqueta;
	private JTextArea areaTexto;
	private JTextField cajaTexto;
	private JButton b1;
	
	public Ventana() {
		
		setBounds(50,50,500,500);
		setTitle("Eventos");
		
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void iniciarComponentes() {
		
		crearPanel();
		crearEtiqueta();
		crearAreaTexto();
		crearBoton();
		crearCajaTexto();
	}
	
	private void crearPanel() {
		
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
		//eventoMovMouse();
		//eventoRuedaRaton();
	}
	
	private void crearEtiqueta() {
		etiqueta = new JLabel("Ingrese un texto: ");
		etiqueta.setBounds(30,10,200,30);
		etiqueta.setFont(new Font("cooper black", 1, 12));
		panel.add(etiqueta);
	}
	private void crearCajaTexto() {
		
		cajaTexto = new JTextField();
		cajaTexto.setBounds( 30, 50, 200, 30);
		panel.add(cajaTexto);
		
		eventoTeclado();

	}
	
	private void crearAreaTexto() {
		areaTexto = new JTextArea();
		areaTexto.setBounds(100,150,300,300);
		panel.add(areaTexto);
	}
	
	private void crearBoton() {
		b1 = new JButton("Continuar");
		b1.setBounds(350,80, 140,40);
		panel.add(b1);
		
		saludo = new JLabel();
		saludo.setBounds(200,400,100,40);
		panel.add(saludo);
		
		//realizarEventoAccion();
		//eventoMouseAccion();
	}
	
	private void realizarEventoAccion() {
		
		//Acciones a los botones
		ActionListener oyenteAccion = new ActionListener() { //Es una interface, solo tiene 1 metodo abstracto, lo implementamos
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saludo.setText("Hola " + areaTexto.getText());
				
			}
		};
		
		b1.addActionListener(oyenteAccion);
		
	}
	
	private void eventoMouseAccion() {
		
		MouseListener oyenteMouse = new MouseListener() { //Interfaz hay que sobreescribir los metodos abstractos
			
			@Override
			public void mouseReleased(MouseEvent e) { //AL soltar sale, tb fuera del boton
				//areaTexto.append("MouseReleased\n");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) { //Desde que se presiona , sin soltar ya sale
				//areaTexto.append("MousePressed\n");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				//areaTexto.append("Sale del boton\n");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//areaTexto.append("Entra en el boton\n");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { //Presionar y solta, cada vez que pasa esto se crea un evento MouseEvent
				//areaTexto.append("Click con el Raton\n");
				
				if(e.isAltDown()) {
					areaTexto.append("Option(alt) pulsado\n");
				}
				else if(e.isShiftDown()) {
					areaTexto.append("Shit pulsado\n");
				}
				
				else if (e.isMetaDown()) {
					areaTexto.append("Clic derecho\n");
				}
				else {
					areaTexto.append("Clic izquierdo\n");
				}
				if (e.getClickCount() == 2) { //DobleClick
					
					areaTexto.append("Has dado doble click\n");
				}
			}
		};
		
		b1.addMouseListener(oyenteMouse);
	}

	private void eventoMovMouse() { //Se anyade al panel
		
		MouseMotionListener oyenteMovRaton = new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {//Se ejecuta cuando  se mueve dentro del panel por cada pixel movido
				
				//areaTexto.append("Mouse Moved\n");
			}
			
			@Override
			public void mouseDragged(MouseEvent e) { //Cuando selecciono cosas por cada pixel movido una vez quedo pulsado
				
				areaTexto.append("Mouse Dragged\n");
			}
		};
		
		panel.addMouseMotionListener(oyenteMovRaton);
		
		
	}

	private void eventoRuedaRaton() {
		
		MouseWheelListener eventoRueda = new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				
				//areaTexto.append("Moviendo Rueda");
				if(e.getWheelRotation() < 0) {
					areaTexto.append("Rueda arriba\n");
				}
				
				if(e.getWheelRotation() > 0) {
					areaTexto.append("Rueda abajo\n");
				}
				
			}
		};
		
		panel.addMouseWheelListener(eventoRueda);
	}

	private void eventoTeclado() {
		
		KeyListener escuchaTeclado = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {// solo admite caracteres, no admiten los control, alt...
				
				areaTexto.append(""+e.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {//Evento al soltar
				//areaTexto.append("Tecla soltada\n");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) { //Solo al presionar
				
				
				
			}
		};
		
		cajaTexto.addKeyListener(escuchaTeclado);
		
	}

}
