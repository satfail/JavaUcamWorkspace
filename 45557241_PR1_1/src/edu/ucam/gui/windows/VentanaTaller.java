package edu.ucam.gui.windows;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.ucam.aplicacion.Cliente;
import edu.ucam.aplicacion.Mecanico;
import edu.ucam.aplicacion.Persona;
import edu.ucam.aplicacion.Trabajo;
import edu.ucam.crud.TallerSingleton;

//Mostrar Jtable , seleccionar trabajo y mecancio de la tabla y crear trabajo
//Boton de Borrado al trabajo seleccionado
public class VentanaTaller extends JFrame {
	private static Persona personaTabla;
	private static Cliente clienteTabla;
	private static Mecanico mecanicoTabla;
	private static Trabajo trabajoTabla;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTitulo, lblTituloInsertar, lblTituloBorrar;
	private JMenuBar menuSuperior;
	private JTable tablaMostrar;
	private JButton btnCliente, btnMecanico, btnBorrar, btnLimpiar,btnInsertar,btnSelecCliente,
	btnSelecMecanico;
	private static TallerSingleton miTaller = TallerSingleton.getTallerSingleton();
	public VentanaTaller(TallerSingleton miTaller) {
		VentanaTaller.miTaller = miTaller;
		VentanaTaller.miTaller.leerDatos();
		setSize(600, 600);
		setTitle("Gestion de Taller");
		setLocationRelativeTo(null);
		colocarPanel();
		colocarMenuSuperior();
		colocarInsertar();
		
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public VentanaTaller() {
		VentanaTaller.miTaller.leerDatos();
		VentanaTaller.miTaller.leerTrabajos();
		setSize(600, 600);
		setTitle("Gestion de Taller");
		setLocationRelativeTo(null);
		colocarPanel();
		colocarMenuSuperior();
		colocarInsertar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private void colocarPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
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
	
	private void colocarInsertar(){
		DefaultTableModel dtm = new DefaultTableModel();
		personaTabla = null; clienteTabla = null; mecanicoTabla = null;
		tablaMostrar = new JTable();
		tablaMostrar.setBounds(240, 80, 300, 200);
		btnCliente = new JButton(); btnMecanico= new JButton();
		btnLimpiar = new JButton(); btnBorrar = new JButton();
		btnCliente.setBounds(100, 100, 100, 40);btnMecanico.setBounds(100, 150, 100, 40);
		btnLimpiar.setBounds(100, 200, 100, 40);
		btnLimpiar.setText("Limpiar");btnCliente.setText("Clientes");btnMecanico.setText("Mecanicos");
		lblTitulo = new JLabel();lblTituloInsertar = new JLabel(); lblTituloBorrar = new JLabel();
		lblTitulo.setText("Taller");lblTituloInsertar.setText("Insertar Trabajo"); lblTituloBorrar.setText("Borrar Trabajo");
		lblTitulo.setBounds(250,50, 100,30);lblTituloInsertar.setBounds(250, 300, 100, 30);
		panel.add(lblTitulo);panel.add(lblTituloInsertar);
		String[] columnas = { "ID","Nombre", "Apellido"};
		
		dtm.addColumn("ID");dtm.addColumn("Nombre");
		dtm.addColumn("Apellido");
		dtm.setColumnIdentifiers(columnas);
		
	
		
		btnCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = dtm.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    dtm.removeRow(i);
				}
				for(Entry<String, Persona> p: miTaller.getPersonas().entrySet()) {
					if(p.getValue() instanceof Cliente) {
							dtm.addRow(new Object[] {
							p.getKey(), p.getValue().getNombre(),
							p.getValue().getApellido()});
					}
				}
				
			}
		});
		
		btnMecanico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = dtm.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    dtm.removeRow(i);
				}
				for(Entry<String, Persona> p: miTaller.getPersonas().entrySet()) {
					if(p.getValue() instanceof Mecanico) {
							dtm.addRow(new Object[] {
							p.getKey(), p.getValue().getNombre(),
							p.getValue().getApellido()});
					}
				}
				
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = dtm.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    dtm.removeRow(i);
				}
			}
		});
		JSeparator sp = new JSeparator();
		sp.setOrientation(SwingConstants.HORIZONTAL);
		sp.setBounds(0, 290, 600, 5);
		panel.add(sp);
		btnSelecCliente=new JButton(); btnSelecMecanico = new JButton();
		btnInsertar = new JButton();
		btnSelecCliente.setText("Seleccionar Cliente"); btnSelecMecanico.setText("Seleccionar Mecanico");
		btnSelecCliente.setBounds( 150, 330, 150, 40); btnSelecMecanico.setBounds(300, 330, 150, 40);
		btnInsertar.setText("Insertar");btnInsertar.setBounds(235, 370, 150, 40);
		panel.add(btnSelecCliente);panel.add(btnSelecMecanico);panel.add(btnInsertar);
		tablaMostrar.setModel(dtm);
		panel.add(tablaMostrar);	
		ListSelectionModel selectionModel = tablaMostrar.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String id = null;
				if(e.getValueIsAdjusting()) {
					int filaSeleccionada = tablaMostrar.getSelectedRow();
					
					id = (String) dtm.getValueAt(filaSeleccionada,0);
					System.out.println(id);
					personaTabla = miTaller.getPersonas().get(id);
					id = null;
				}
				
				
			}
		});
		btnSelecCliente.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(personaTabla instanceof Cliente) {
					clienteTabla = (Cliente) personaTabla;
					JOptionPane.showMessageDialog(null,  "Cliente Insertado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
				}
			}
		});
		
		btnSelecMecanico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(personaTabla instanceof Mecanico) {
					mecanicoTabla = (Mecanico)personaTabla;
					JOptionPane.showMessageDialog(null,  "Mecanico Insertado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccione un Mecanico");
				}
			}
		});
		
		btnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clienteTabla !=null && mecanicoTabla != null) {
					Trabajo trabajo = new Trabajo(0, new Date(System.currentTimeMillis()), null, 
							clienteTabla.getAuto(), clienteTabla, mecanicoTabla);
					TallerSingleton.getTrabajos().put(miTaller.getKey(trabajo), trabajo);
					miTaller.generarInformeTrabajos();
				}else {
					JOptionPane.showMessageDialog(null, "Inserte un Cliente y Mecanico");
				}
			}
		});
		panel.add(btnCliente);panel.add(btnMecanico);panel.add(btnLimpiar);
	
		JSeparator sp2 = new JSeparator();
		sp2.setOrientation(SwingConstants.HORIZONTAL);
		sp2.setBounds(0, 415, 600, 5);
		panel.add(sp2);
		lblTituloBorrar.setBounds(250, 425, 100, 30);
		panel.add(lblTituloBorrar); btnBorrar.setBounds(225, 455, 150, 40);
		btnBorrar.setText("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Introduza la ID del Trabajo (Ejemplo: T1)");
				Trabajo trabajo = null;
				String mensaje;
				trabajo = miTaller.getTrabajos().remove(id);
				if(trabajo != null) {
					mensaje = id + " Cliente : " + trabajo.getCliente().getNombre() + " Mecanico : "+
										trabajo.getMecanico().getNombre();
					JOptionPane.showConfirmDialog(null, mensaje);
				}else {
					JOptionPane.showMessageDialog(null, "Error al borrar el trabajo");
				}
				
			}
		});
		panel.add(btnBorrar);
		
		
		
		
		
		
	}

}
