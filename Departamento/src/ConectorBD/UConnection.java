package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			
			if (con == null) {
				
				Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				
				ResourceBundle rb = ResourceBundle.getBundle("ConectorBD.jdbc");
				String driver = rb.getString("driver");
				String url = rb.getString("url");
				String pwd = rb.getString("pwd");
				String usr= rb.getString("usr");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url,usr,pwd);
			}
			return con;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion",ex);
		}
	}
	
	static class MiShDwnHook extends Thread{ //Inner class, clase interna dentro de la clase contenedora
											 //Esto solo tiene sentido si la clase interna es totalmente dependiente de la contenedora
											 // Inner tiene acceso a los miembros de la contenedora AUNQUE SEAN PRIVADOS
											 // Una contiene a la otra pero NO EXISTE HERENCIA ENTRE ELLAS
		
		public void run() {
			
			try {
				Connection con = UConnection.getConnection();
				con.close();
			}
			
			catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			
			}
		}
		
	}	
}

