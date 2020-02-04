package edu.ucam.gui.windows;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField user;
	private JPasswordField pass;
	private JLabel loginLabel;
	private JLabel loginUser;
	private JLabel loginPass;
	private JButton botonContinuar;
	private VentanaTaller ventanaMain;
	public VentanaLogin() {
		setSize(400, 400); 
		setTitle("Login");
		setLocationRelativeTo(null);
		colocarPanel();
		colocarTexto();
		colocarBoton();

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void colocarPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 400, 400);
		panel.setLayout(null);
		this.add(panel);
		
	}
	
	private void colocarTexto() {
		user = new JTextField();
		pass = new JPasswordField();
		loginLabel = new JLabel();
		loginUser = new JLabel();
		loginPass = new JLabel();
		user.setBounds(150, 120, 150, 30);
		pass.setBounds(150, 170, 150, 30);
		loginLabel.setBounds(180, 80, 150, 30);
		loginLabel.setText("LOGIN");
		loginLabel.setFont(new Font("arial", 0, 20));
		loginUser.setBounds(80, 120, 50, 30);
		loginUser.setText("User :");
		loginPass.setBounds(80, 170, 80, 30);
		loginPass.setText("Password : ");
		panel.add(loginLabel);
		panel.add(loginUser);
		panel.add(loginPass);
		panel.add(pass);
		panel.add(user);
		
	}
	
	private void colocarBoton() {
		botonContinuar = new JButton();
		botonContinuar.setBounds(270, 320, 110, 35);
		botonContinuar.setText("Continuar");
		panel.add(botonContinuar);
		ActionListener eventoBoton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getText().equalsIgnoreCase("admin")) {
					String password = "";
					for (int i = 0; i < pass.getPassword().length; i++) {
						password += pass.getPassword()[i];
					}
					if(password.equalsIgnoreCase("admin")){
						dispose();
						colocarVentanaMain();
					}else {
						JOptionPane.showMessageDialog(null, "Error al introducir el password");

					}
				}else {
					JOptionPane.showMessageDialog(null, "Error al introducir el usuario");

				}
					
				
			}
		};
		botonContinuar.addActionListener(eventoBoton);

	}
	
	private  void colocarVentanaMain() {
		ventanaMain = new VentanaTaller();
		ventanaMain.setVisible(true);
	}
}
