package Manejo;

public class Usuario {

	public String nombre;
	public String email;
	private String user;
	private String pass;
	
	public Usuario(String nom, String p) {
		
		this.nombre = nom;
		this.pass = p;
	}
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public  void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public String getEmail() {
		return email;
	}
	public  void setEmail(String em) {
		this.email = em;
	}
	public String getUser() {
		return user;
	}
	public  void setUser(String usr) {
		this.user = usr;
	}
	
	public String getPass() {
		return pass;
	}
	public  void setPass(String p) {
		this.pass = p;
	}
}
