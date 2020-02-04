package edu.ucam.gui.windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.ucam.crud.TallerSingleton;

//Jtable clientes y trabajos

public class VentanaInforme extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JMenuBar menuSuperior;
	private TallerSingleton miTaller;
	public VentanaInforme(TallerSingleton miTaller) {
		this.miTaller = miTaller;
		setSize(600, 600);
		setTitle("Gestion de Informes");
		setLocationRelativeTo(null);
		colocarPanel();
		colocarMenuSuperior();
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private void colocarPanel() {
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(null);
	}
	
	private void colocarMenuSuperior() {
		menuSuperior = new JMenuBar();
		menuSuperior.setBounds(0, 0, 600, 40);
		menuSuperior.setBackground(new Color(220,220,220));
		
		panel.add(menuSuperior);
		
		JMenuItem itemCliente = new JMenuItem("Gestion Clientes");
		itemCliente.setBounds(0,0,100,40);
		menuSuperior.add(itemCliente);
		ActionListener eventoCliente = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCliente ventanaCliente = new VentanaCliente(miTaller);
				dispose();
				ventanaCliente.setVisible(true);
				
				
			}
		};
		itemCliente.addActionListener(eventoCliente);
		JMenuItem itemTaller = new JMenuItem("Gestion Taller");
		itemTaller.setBounds(150,0,100,40);
		menuSuperior.add(itemTaller);
		ActionListener eventoTaller = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTaller ventanaTaller = new VentanaTaller(miTaller);
				dispose();
				ventanaTaller.setVisible(true);
				
				
			}
		};
		itemTaller.addActionListener(eventoTaller);
		JMenuItem itemInformes = new JMenuItem("Informes");
		itemTaller.setBounds(300,0,100,40);
		menuSuperior.add(itemInformes);
		ActionListener eventoInforme = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInforme ventanaInforme = new VentanaInforme(miTaller);
				dispose();
				ventanaInforme.setVisible(true);

			}
		};
		itemInformes.addActionListener(eventoInforme);
		

		
		
		
	}
	

}
