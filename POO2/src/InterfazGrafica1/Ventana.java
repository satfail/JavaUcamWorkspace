package InterfazGrafica1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{
	
	public JPanel panel = new JPanel(); //creo el panel
	
	public Ventana() {
		
		this.setSize(300, 300); //Tamanyo de la ventana
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Cerrar la ventana al dar a x
		setTitle("Hola Mundo"); //Titulo de la Ventana
		//setResizable(false);// no deja redimensionar la ventana
		setMinimumSize(new Dimension(300,300));
		//this.getContentPane().setBackground(Color.LIGHT_GRAY);//Establece el color de la ventana
		/*La ventana aparece en la esquina sup izq por defecto el punto (0, 0) que es el punto antes descrito*/
		
		//setLocation(500, 200); //Son pixeles (x,y)
		
		//setBounds(600, 300, 300, 300 ); //setSize + setLocation (x,y,ancho,alto)
		
		setLocationRelativeTo(null); // Con null aparece en el centro
		
		/* Un panel es un contonedor de componentes para no poner cosas justo encima de la ventana */
		
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		
		crearPaneles();
		//colocarEtiquetas();
		//crearBotones();
		//crearRadioBotones();
		//crearBotonesActivacion();		
		//crearCajasTexto();
		//crearAreasTexto();
		//crearCasillasVerificacion();
		//crearListasDesplegables();
		//crearCampoPassword();
		//crearTablas();
		crearListas();
	}
	public void colocarEtiquetas() {
		
		JLabel etiqueta = new JLabel("Buenos Dias"); //Etiqueta de texto con constructor con string
		etiqueta.setBounds(100,200,100,20);
		etiqueta.setForeground(Color.RED);//Cambio el color del texto
		etiqueta.setOpaque(true);//Quito que sea transparente
		etiqueta.setBackground(Color.BLUE);//No deja por defecto cambiarlo, hay que desactivar que no sea transparente
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//El texto centrado horizontalmente, se pasa un entero como paramentro
		etiqueta.setFont(new Font("arial", Font.ITALIC,16)); //Nombre, estilo y tamanyo
		//que forma parte de las constantes de Swing, tb se puede pasar como parametro en el constructor String , int
		panel.add(etiqueta); //Agregamos la etiqueta al panel
		
		//ETIQUETA 2
		ImageIcon imagen = new ImageIcon("foto.jpg");
		JLabel etiqueta2 = new JLabel();
		etiqueta2.setBounds(0,0, 300, 300);// hacemos la equieta mas pequenya no la imagen
		panel.add(etiqueta2);
		etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
		System.out.println(new File(".").getAbsolutePath());
		
	}
	
	public void crearPaneles() {
		
		panel = new JPanel(); //creo el panel
		//panel.setBackground(Color.GREEN);//para ver que el panel esta puesto
		this.getContentPane().add(panel); //anyado el panel
		
		//Creamos etiquetas
		//Tanto la ventana como el panel tienen Lyaouts por defecto
		panel.setLayout(null);//quitamos el disenyo del panel para poder mover etiquetas libremente
	}
	
	public void crearBotones() {
		//b1 boton de texto
		JButton b1 = new JButton("Continuar");
		b1.setBounds(210, 230, 80, 40);
		//b1.setEnabled(false); //Interaccion con el boton false, no deja
		b1.setMnemonic('a'); //Alt || option + a para pulsar el boton
		b1.setForeground(Color.RED);//Color letra del boton
		b1.setFont(new Font("arial", 3, 12));
		
		//b2 de imagen
		JButton b2 = new JButton();
		b2.setBounds(0, 230, 80, 40);
		//b2.setOpaque(true);
		//b2.setBackground(Color.BLUE);
		ImageIcon imagenB2 = new ImageIcon("boton.png");
		b2.setIcon(new ImageIcon(imagenB2.getImage().getScaledInstance(b2.getWidth(), b2.getHeight(), Image.SCALE_SMOOTH)));
		
		JButton b3 = new JButton();
		b3.setBounds(210, 0, 80, 50);
		b3.setBorder(BorderFactory.createLineBorder(Color.RED, 3, false));
		
		panel.add(b2);
		panel.add(b1);
		panel.add(b3);
	}
	
	
	public void crearRadioBotones() {
		
		JRadioButton rb1 = new JRadioButton("Opcion 1" , true);
		rb1.setBounds(100, 50, 100, 80);
		rb1.setEnabled(false);
		panel.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Opcion 2" , false);
		rb2.setBounds(100, 100, 100, 80);
		panel.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("Opcion 3" , false);
		rb3.setBounds(100, 150, 100, 80);
		panel.add(rb3);
		
		ButtonGroup grb1 = new ButtonGroup();
		grb1.add(rb1);
		grb1.add(rb2); //Anyado los rb al grupo
		grb1.add(rb3);
	}
	
	public void crearBotonesActivacion(){
		
		JToggleButton activacion1 = new JToggleButton("Opcion 1", false);
		activacion1.setBounds(100, 50, 100,40);
		panel.add(activacion1);
		
		JToggleButton activacion2 = new JToggleButton("Opcion 2", true);
		activacion2.setBounds(100, 100, 100,40);
		panel.add(activacion2);
		
		JToggleButton activacion3 = new JToggleButton("Opcion 3", false);
		activacion3.setBounds(100, 150, 100,40);
		panel.add(activacion3);
		
		ButtonGroup grupoBActivados = new ButtonGroup();
		grupoBActivados.add(activacion1);
		grupoBActivados.add(activacion2);
		grupoBActivados.add(activacion3);
		
	}

	public void crearCajasTexto() {
		
		JTextField linea = new JTextField("hola mundo", 50); //Es una linea solamente, las columnas es para el Lyout le decimos cuatas tiene
		linea.setBounds(50,50,100,30);
		//linea.setText("Introduzca ...");
		System.out.println("El texto que hay en la caja es : " + linea.getText());
		panel.add(linea);
		
		
	}

	
	public void crearAreasTexto() {
		
		JTextArea areaTexto = new JTextArea(); //Tiene filas y columas para el Lyout
		areaTexto.setBounds(20, 40, 225, 120);
		areaTexto.setText("Escriba texto aqui");
		areaTexto.append("...");
		areaTexto.setEditable(true);
		System.out.println("El texto es : " + areaTexto.getText());
		panel.add(areaTexto);		
	
		//Barras de desplazamiento para la caja de texto
		JScrollPane barrasDesplazamiento = new JScrollPane(areaTexto,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		barrasDesplazamiento.setBounds(areaTexto.getX(), areaTexto.getY(), areaTexto.getWidth(), areaTexto.getHeight());
		//barrasDesplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		//barrasDesplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(barrasDesplazamiento);
	
	}
	
	public void crearCasillasVerificacion() {
		
		JCheckBox verificacionBox = new JCheckBox("Opcion 1 ");
		verificacionBox.setBounds(20, 20, 100, 40);
		JCheckBox verificacionBox2 = new JCheckBox("Opcion 2 ",true);
		verificacionBox2.setBounds(20, 50, 100, 40);
		JCheckBox verificacionBox3 = new JCheckBox("Opcion 3 ");
		verificacionBox3.setBounds(20, 80, 100, 40);
		
		panel.add(verificacionBox);
		panel.add(verificacionBox2);
		panel.add(verificacionBox3);
		
	}
	
	public void crearListasDesplegables() {
		
		String[] paises = { "Espanya", "Peru","Ecuador","ModernDonia"};
		JComboBox listaDesplegable1 = new JComboBox(paises);
		listaDesplegable1.setBounds(20,20,130,40);
		listaDesplegable1.addItem("Argentina");
		listaDesplegable1.setSelectedItem("ModernDonia");
		panel.add(listaDesplegable1);
		
		
		
		Persona p1 = new Persona("Miguel" , 33 , "Spain");
		Persona p2 = new Persona("Maria Jose", 34, "Spain");
		
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		modelo.addElement(p1); //He sobrescrito toString para que devuelva el nombre directamente
		modelo.addElement(p2); // Lo bueno de esto es que selecciono el objeto entero, no solo muestro el nombre aunque lo parezca.
		JComboBox listaDesplegable2 =  new JComboBox(modelo);
		listaDesplegable2.setBounds(160,20,130,40);
		panel.add(listaDesplegable2);
	}

	public void crearCampoPassword() {
		
		JPasswordField pwd = new JPasswordField();
		pwd.setBounds(20, 20, 100, 30);
		pwd.setText("POOOOOO");//Ya no se puede hacer getText del contrasenya 
		
		String passString = "";
		
		//El metodo getPassword devuelve un array de carcateres, por lo tanto hay que recorrerlo para obtener el String bien
		for(int i = 0 ; i < pwd.getPassword().length; i++) {
			
			passString += pwd.getPassword()[i];
			
		}
		System.out.println("La clave es " + passString);
		panel.add(pwd);
	}

	public void crearTablas() {
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Edad");
		modelo.addColumn("Nacionalidad");
		
		String [] persona1 = {"Lucas", "3","Spain"};
		String [] persona2 = {"Carmen", "0.6","Spain"};
		modelo.addRow(persona1);
		modelo.addRow(persona2);
		
		
		JTable tabla = new JTable(modelo);
		tabla.setBounds(20, 20, 250, 150);
		panel.add(tabla);
		
		JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		//Para que se vean los nombres de las tablas
		scroll.setBounds(tabla.getX(), tabla.getY(),tabla.getWidth(), tabla.getHeight());
		panel.add(scroll);
		
		
		
		
	}
	
	public void crearListas() {
		
		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement(new Persona("Miguel", 33, "Spain"));	 //Sobreescrito toString para que muestre el nombre
		modelo.addElement(new Persona("Maria Jose", 34, "Spain"));		
		JList lista = new JList(modelo);
		lista.setBounds(30, 20, 200, 240);
		panel.add(lista);
		
		JScrollPane scroll = new JScrollPane(lista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(lista.getX(),lista.getY(),lista.getWidth(),lista.getHeight());
		panel.add(scroll);
		
		
	}
	
	public static void main(String[] args) {
		
		Ventana v1 = new Ventana();
		v1.setVisible(true);//Hacemos Visible la ventana
		
		
	}
	

}
