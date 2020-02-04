package edu.ucam.gui.windows;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu.Separator;
import javax.swing.border.Border;
import javax.swing.JSeparator;

import edu.ucam.aplicacion.Automovil;
import edu.ucam.aplicacion.Cliente;
import edu.ucam.aplicacion.Jefe;
import edu.ucam.aplicacion.Mecanico;
import edu.ucam.aplicacion.Moto;
import edu.ucam.aplicacion.Persona;
import edu.ucam.aplicacion.Turismo;
import edu.ucam.crud.TallerSingleton;

public class VentanaCliente extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private Persona persona;
	private Automovil automovil;
	JPanel panel;
	JMenuBar menuSuperior;
	JPanel panelInsertar;
	JPanel panelBorrar,panelPrincipal,panelBuscar;
	JPanel cliente, mecanico,jefe,comercial;
	JButton insertar,borrar,buscar;
	private TallerSingleton miTaller;
	CardLayout cl;
	private JTextField txtNombre,txtApellido, txtDni, txtMarca, txtModelo, txtMatricula;
	private JTextField  txtnPuertas, txtCapacidad, txtCilindrada,txtTipoMoto,txtCaballos,txtBuscar;
	private JLabel  lblnPuertas,lblCapacidad, lblCilindrada,lblTipoMoto;
	private JLabel  lblNombre,lblApellido, lblDni, lblMarca, lblModelo, lblMatricula,lblTipoPersona,lblTipoAuto,
	lblCaballos,lblBuscar;

	public VentanaCliente(TallerSingleton miTaller) {
		this.miTaller = miTaller;
		setSize(600, 600);
		setTitle("Gestion de Clientes");
		setLocationRelativeTo(null);
		colocarPanel();
		colocarMenuSuperior();
		colocarBotones(); 
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	///Borrar  y mostrar datos
	///Buscar y mostrar datos
	
	private void colocarPanel() {
		cl = new CardLayout();
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(cl);
		panel = new JPanel();
		panel.setLayout(null);
		panelInsertar = new JPanel();
		panelInsertar.setLayout(null);
		panelBorrar = new JPanel();
		panelBorrar.setLayout(null);
		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		cliente = new JPanel();
		cliente.setLayout(null);
		panelPrincipal.add(panel, "0");
		panelPrincipal.add(panelInsertar, "1");
		panelPrincipal.add(panelBorrar, "2");
		panelPrincipal.add(panelBuscar,"3");
		panelPrincipal.add(cliente,"4");
		cl.show(panelPrincipal, "0");
		panel.setBounds(0, 0, 600, 600);
		panelInsertar.setBounds(0, 0, 600, 600);
		panelBorrar.setBounds(0, 0, 600, 600);
		panelBuscar.setBounds(0, 0, 600, 600);
		this.add(panelPrincipal);
	}
	
	private void colocarPanelInsertar() {
		cl.show(panelPrincipal, "1");
		colocarInsertar();
	}
	
	private void colocarPanelBorrar() {
		cl.show(panelPrincipal, "2");
		colocarBorrar();
		//Borrar y JoptionPane
	}
	private void colocarPanelBuscar() {
		cl.show(panelPrincipal, "3");
		colocarBuscar();
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
	
	private void colocarBotones(){
		insertar = new JButton();
		insertar.setBounds(230, 150, 150, 50);
		insertar.setText("Insertar Clientes");
		borrar = new JButton();
		borrar.setBounds(230, 250, 150, 50);
		borrar.setText("Borrar Clientes");
		buscar = new JButton();
		buscar.setBounds(230, 350 , 150, 50);
		buscar.setText("Buscar Clientes");
		panel.add(insertar);panel.add(borrar);panel.add(buscar);
		
		ActionListener eventoInsertar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colocarPanelInsertar();
			}
		};
		insertar.addActionListener(eventoInsertar);
		
		ActionListener eventoBorrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colocarPanelBorrar();
			}
		};
		borrar.addActionListener(eventoBorrar);
				
		ActionListener eventoBuscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colocarPanelBuscar();
			}
		};
		buscar.addActionListener(eventoBuscar);
	
	}
	
	private void colocarInsertar() {
					lblCaballos = new JLabel(); txtCaballos = new JTextField();
					cl.show(panelPrincipal, "4");
					colocarInsertarComun(cliente);
					lblTipoPersona.setText("Cliente");
					lblTipoPersona.setBounds(250,50, 100,30);
					cliente.add(lblTipoPersona);
					lblTipoAuto.setText("Automovil");
					lblTipoAuto.setBounds(250, 220, 150, 30);
					cliente.add(lblTipoAuto);
					lblMarca.setText("Marca : "); 
					lblMarca.setBounds(20, 250, 100, 30); txtMarca.setBounds(100, 250, 150, 30);
					cliente.add(lblMarca);cliente.add(txtMarca);
					lblModelo.setText("Modelo : "); 
					lblModelo.setBounds(300, 250, 100, 30); txtModelo.setBounds(400, 250, 150, 30);
					cliente.add(lblModelo);cliente.add(txtModelo);
					lblMatricula.setText("Matricula : ");
					lblMatricula.setBounds(20, 300, 100, 30); txtMatricula.setBounds(100, 300, 150, 30);
					cliente.add(lblMatricula);cliente.add(txtMatricula);
					lblCaballos.setText("Caballos : ");
					lblCaballos.setBounds(300, 300, 100, 30); txtCaballos.setBounds(400, 300, 150, 30);
					cliente.add(lblCaballos);cliente.add(txtCaballos);
					JSeparator sp = new JSeparator();
					sp.setOrientation(SwingConstants.HORIZONTAL);
					sp.setBounds(0, 350, 600, 5);
					cliente.add(sp);
					JLabel lblTuris = new JLabel("Turismo : ");
					lblTuris.setBounds(250, 380, 150, 30);cliente.add(lblTuris);
					lblnPuertas = new JLabel();txtnPuertas = new JTextField();
					lblnPuertas.setText("Puertas : ");
					lblnPuertas.setBounds(20, 400, 150, 30);txtnPuertas.setBounds(100, 400, 150, 30);
					cliente.add(lblnPuertas);cliente.add(txtnPuertas);
					lblCapacidad = new JLabel(); txtnPuertas = new JTextField();
					lblCapacidad.setText("Capacidad : ");
					lblCapacidad.setBounds(300, 400, 150, 30);txtCapacidad.setBounds(400, 400, 150, 30);
					cliente.add(lblCapacidad);cliente.add(txtCapacidad);
					
					JSeparator sp2 = new JSeparator();
					sp2.setOrientation(SwingConstants.HORIZONTAL);
					sp2.setBounds(0, 440, 600, 5);
					cliente.add(sp2);
					JLabel lblMoto = new JLabel("Moto : ");
					lblMoto.setBounds(250, 450, 150, 30);cliente.add(lblMoto);
					lblCilindrada = new JLabel();txtCilindrada = new JTextField();
					lblCilindrada.setText("Cilindrada : ");
					lblCilindrada.setBounds(20, 480, 150, 30);txtCilindrada.setBounds(100, 480, 150, 30);
					cliente.add(lblCilindrada);cliente.add(txtCilindrada);
					lblTipoMoto = new JLabel(); txtTipoMoto = new JTextField();
					lblTipoMoto.setText("Tipo : ");
					lblTipoMoto.setBounds(300, 480, 150, 30);txtTipoMoto.setBounds(400, 480, 150, 30);
					cliente.add(lblTipoMoto);cliente.add(txtTipoMoto);
					
					JButton atras= new JButton("Volver"), continuar = new JButton("Continuar");
					atras.setBounds(20	, 520, 100, 40);continuar.setBounds(500, 520, 100	, 40);
					atras.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							cl.show(panelPrincipal, "0");
							
						}
					});
					continuar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String nombre, apellido, dni, marca,modelo,matricula,tipoMoto = "",
							 caballos = "", nPuertas = "", cilindrada = "", capacidad = "";
							nombre = txtNombre.getText(); apellido = txtApellido.getText();dni=txtDni.getText();
							marca= txtMarca.getText();modelo= txtModelo.getText(); matricula=txtMatricula.getText();
							caballos = txtCaballos.getText();
							try {
							if(cilindrada.equals("") || tipoMoto.equals("")) {
								nPuertas = txtnPuertas.getText();
								capacidad = txtCapacidad.getText();
								automovil = new Turismo(matricula, Integer.parseInt(caballos), marca, modelo);
								persona  =new Cliente(nombre, apellido, dni, automovil);
								((Cliente)persona).setFechaAlta(new Date(System.currentTimeMillis()));
							}
							if(nPuertas.equals("") || capacidad.equals("")) {
								cilindrada = txtCilindrada.getText();
								tipoMoto = txtTipoMoto.getText();
								automovil = new Moto(matricula, Integer.parseInt(caballos), marca, modelo, Integer.parseInt(cilindrada), tipoMoto);
								persona  =new Cliente(nombre, apellido, dni, automovil);
								((Cliente)persona).setFechaAlta(new Date(System.currentTimeMillis()));
							}
							}catch (NumberFormatException ex) {
								
							}
							miTaller.getPersonas().put(miTaller.getKey(persona), persona);
							miTaller.generarInformePersonal();
							
							
						}
					});
					cliente.add(atras);cliente.add(continuar);
		
					
				}
			

	private void colocarInsertarComun(JPanel panelInsertar ) {
		persona = null;
		automovil = null;
		lblNombre =new JLabel();txtNombre = new JTextField();
		lblApellido =new JLabel();txtApellido = new JTextField();
		lblDni =new JLabel();txtDni = new JTextField();
		lblMarca =new JLabel();txtMarca = new JTextField();
		lblMatricula =new JLabel();txtMatricula = new JTextField();
		lblModelo =new JLabel();txtModelo = new JTextField();
		lblnPuertas = new JLabel(); txtnPuertas = new JTextField();
		lblCapacidad = new JLabel(); txtCapacidad = new JTextField();
		lblCilindrada = new JLabel(); txtCilindrada = new JTextField();
		lblTipoMoto = new JLabel(); txtTipoMoto = new JTextField();
		lblTipoPersona = new JLabel(); lblTipoAuto = new JLabel();
				
		lblNombre.setText("Nombre : ");
		lblNombre.setBounds(20,100, 100, 30); txtNombre.setBounds(100, 100, 150, 30);
		panelInsertar.add(lblNombre); panelInsertar.add(txtNombre);
		lblApellido.setText("Apellido : ");
		lblApellido.setBounds(300,100, 100, 30); txtApellido.setBounds(400, 100, 150, 30);
		panelInsertar.add(lblApellido); panelInsertar.add(txtApellido);
		lblDni.setText("Dni : ");
		lblDni.setBounds(20,150, 100, 30); txtDni.setBounds(100, 150, 150, 30);
		panelInsertar.add(lblDni); panelInsertar.add(txtDni);
		JSeparator sp = new JSeparator();
		sp.setOrientation(SwingConstants.HORIZONTAL);
		sp.setBounds(0, 190, 600, 5);
		panelInsertar.add(sp);
	}
	
	private void colocarBorrar(){
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Borrar");
		lblTitulo.setBounds(250,50, 100,30);
		panelBorrar.add(lblTitulo);
		colocarBuscarBorrarComun(panelBorrar);
		JButton atras= new JButton("Volver"), continuar = new JButton("Continuar");
		atras.setBounds(20	, 520, 100, 40);continuar.setBounds(500, 520, 100	, 40);
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelPrincipal, "0");
			}
		});
		
		continuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = null;
				id = txtBuscar.getText();
				Persona personaBorrada = null;
				personaBorrada = miTaller.getPersonas().remove(id);
				if(personaBorrada != null) {
					txtNombre.setText(personaBorrada.getNombre());
					txtApellido.setText(personaBorrada.getApellido());
					txtDni.setText(personaBorrada.getDni());
					JOptionPane.showMessageDialog(null, "Cliente borrado correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Borrar la persona");
				}
				
			}
		});
		panelBorrar.add(atras);panelBorrar.add(continuar);
	}
	
	
	private void colocarBuscar() {
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Buscar");
		lblTitulo.setBounds(250,50, 100,30);
		panelBuscar.add(lblTitulo);
		
		colocarBuscarBorrarComun(panelBuscar);
		
		JButton atras= new JButton("Volver"), continuar = new JButton("Continuar");
		atras.setBounds(20	, 520, 100, 40);continuar.setBounds(500, 520, 100	, 40);
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelPrincipal, "0");
			}
		});
		
		continuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = null;
				id = txtBuscar.getText();
				Persona personaBuscada = null;
				personaBuscada = miTaller.getPersonas().get(id);
				if(personaBuscada != null) {
					txtNombre.setText(personaBuscada.getNombre());
					txtApellido.setText(personaBuscada.getApellido());
					txtDni.setText(personaBuscada.getDni());
					JOptionPane.showMessageDialog(null, "Cliente Buscado correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Buscar la persona");
				}
				
			}
		});
		panelBuscar.add(atras);panelBuscar.add(continuar);
	}
	
	private void colocarBuscarBorrarComun(JPanel panelBorrar) {
		
		lblBuscar = new JLabel();txtBuscar = new JTextField();
		lblNombre =new JLabel();txtNombre = new JTextField();
		lblApellido =new JLabel();txtApellido = new JTextField();
		lblDni =new JLabel();txtDni = new JTextField();
		
		
		
		lblBuscar.setText("Introduzca ID : ");
		lblBuscar.setBounds(20, 100, 100, 30); panelBorrar.add(lblBuscar);
		txtBuscar.setBounds(130,100,150,30);panelBorrar.add(txtBuscar);
		lblNombre.setText("Nombre : ");
		lblNombre.setBounds(20,200, 100, 30); txtNombre.setBounds(100, 200, 150, 30);
		panelBorrar.add(lblNombre); panelBorrar.add(txtNombre);
		lblApellido.setText("Apellido : ");
		lblApellido.setBounds(300,200, 100, 30); txtApellido.setBounds(400, 200, 150, 30);
		panelBorrar.add(lblApellido); panelBorrar.add(txtApellido);
		lblDni.setText("Dni : ");
		lblDni.setBounds(20,250, 100, 30); txtDni.setBounds(100, 250, 150, 30);
		panelBorrar.add(lblDni); panelBorrar.add(txtDni);
		JSeparator sp = new JSeparator();
		sp.setOrientation(SwingConstants.HORIZONTAL);
		sp.setBounds(0, 290, 600, 5);
		panelBorrar.add(sp);
		
		JSeparator sp2 = new JSeparator();
		sp2.setOrientation(SwingConstants.HORIZONTAL);
		sp2.setBounds(0, 180, 600, 5);
		panelBorrar.add(sp2);
	}
}
