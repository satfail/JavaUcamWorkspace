package InterfazGrafica4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaJF extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField cajaNombre;
	private JTextField cajaApellido;
	private JTextField cajaEmail;
	private JTextField cajaMovil;
	private JTextField cajaDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJF frame = new VentanaJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 516, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelPersona = new JLabel("Persona");
		labelPersona.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		labelPersona.setBounds(21, 20, 75, 24);
		panel.add(labelPersona);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 56, 150, 27);
		panel.add(comboBox);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(378, 55, 117, 29);
		panel.add(btnContinuar);
		
		table = new JTable();
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(21, 90, 458, 72);
		panel.add(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 187, 489, 2);
		panel.add(separator);
		
		JLabel etiquetaDatos = new JLabel("Datos de la Persona");
		etiquetaDatos.setBounds(21, 201, 130, 16);
		panel.add(etiquetaDatos);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(21, 260, 221, 26);
		panel.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(19, 232, 61, 16);
		panel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(281, 232, 61, 16);
		panel.add(lblApellidos);
		
		cajaApellido = new JTextField();
		cajaApellido.setBounds(281, 260, 187, 26);
		panel.add(cajaApellido);
		cajaApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 325, 61, 16);
		panel.add(lblEmail);
		
		cajaEmail = new JTextField();
		cajaEmail.setBounds(21, 353, 172, 26);
		panel.add(cajaEmail);
		cajaEmail.setColumns(10);
		
		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setBounds(281, 325, 61, 16);
		panel.add(lblMovil);
		
		cajaMovil = new JTextField();
		cajaMovil.setBounds(281, 353, 187, 26);
		panel.add(cajaMovil);
		cajaMovil.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(207, 390, 61, 16);
		panel.add(lblDireccion);
		
		cajaDireccion = new JTextField();
		cajaDireccion.setBounds(21, 418, 447, 26);
		panel.add(cajaDireccion);
		cajaDireccion.setColumns(10);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(0, 6, 600, 22);
		panel.add(barraMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		barraMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		barraMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		barraMenu.add(mntmNewMenuItem_2);
	}
}
