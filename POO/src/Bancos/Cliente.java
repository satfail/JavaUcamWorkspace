package Bancos;

public class Cliente {

	private String nombre , apellido;
	private final String dni;
	
	Cuenta cuentas[];

	public Cliente(String nombre, String apellido, String dni, Cuenta[] cuentas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuentas = cuentas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}

	public String getDni() {
		return dni;
	}
	
	public double consultarSaldo(Cuenta cuenta) {
		return cuenta.getSaldo();
	}
	
	public void ingresarDinero(Cuenta cuenta,double cantidad) {
		
		cuenta.ingresarDinero(cantidad);
	}
	
	public void retirarDinero(Cuenta cuenta,double cantidad) {
		
		cuenta.retirarDinero(cantidad);
	}
	
	
}
 