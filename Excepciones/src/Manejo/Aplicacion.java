package Manejo;

import java.util.ResourceBundle;

public class Aplicacion {

	public Usuario login(String usrname, String password) {
		try
		{
			
			ResourceBundle rb =  ResourceBundle.getBundle("Manejo.usuario"); //Leemos el archivo, lo lee respetando sintaxis de programacion
			// no es una lectura a webo
			String usr = rb.getString("usrname"); // leemos el valor de la propiedad username
			String pwd = rb.getString("password");
			Usuario u = null; //Definimos la variable de retorno
			
			if(usr.equals(usrname) && pwd.equals(password)) { //Comparo lo del texto con lo recibido por parametro
				
				u = new Usuario();	//Instancia y sets
				u.setNombre(rb.getString("nombre"));
				u.setEmail(rb.getString("email"));
				u.setUser(usr);
				u.setPass(pwd);

			}
			return u; //Si es lo mismo entra si no null

		}
		catch(Exception ex) { //Clase base Exception que es sublclase de Throwable
			
			throw new RuntimeException("Error verificando datos ", ex);
		}
	}
}
