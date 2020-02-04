package Bancos;


public class Cuenta {
	
	private final int numeroCuenta;
	private double saldo;
	
	public Cuenta (int numeroCuenta, double saldo) {
		
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void ingresarDinero(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		this.saldo -= cantidad;
	}
	

	
	
	
	

}
