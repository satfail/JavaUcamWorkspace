package SerializableyStreams;
import java.util.*;
import java.io.*;
//SerialVersion UID en la clase seriazable empleado
//En red si cambio en el servidor o emisor el programa deja utilizar en 
//receptor el archivo serializable

public class Serializando {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Empleado [] personal = new Empleado[3];
		
		personal[0] = new Empleado("Lucas", 5000, 36);
		personal[1] = new Empleado("Carmen", 2000, 6);
		personal[2] = new Empleado("Mj", 7000, 70);
		
		
		try {
			//ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("empleados.dat"));
			//escribirFichero.writeObject(personal);
			//System.out.println("Personal Guardado");
			//escribirFichero.close();
			//Leer el fichero
			ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream("empleados.dat"));
			Empleado[] personalLeido = (Empleado[])leerFichero.readObject();

			leerFichero.close();
			for(Empleado e : personalLeido) {
				System.out.println(e);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}



class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private float sueldo;
	int antiguedad;
	public Empleado(String nombre, float sueldo, int antiguedad ) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	public String toString() {
		return "Nombre : " + this.nombre + " Sueldo : " + this.sueldo;
	}
	
}
