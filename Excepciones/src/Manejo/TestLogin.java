package Manejo;


public class TestLogin {

	public static void main(String[] args) {
		
		try {
			Aplicacion app = new Aplicacion();
			Usuario u = app.login("juan", "juan123sito");
			System.out.println(u.nombre);
			System.out.println(u.email);

			
		}
		catch(Exception ex) {
			System.out.println("Servicio temporalmente interrumpido ");
			System.out.println(ex.getMessage());
			
		}
	}
	
}
